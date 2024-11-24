package online.jutter.cow.data.db.repositories

import online.jutter.cow.data.db.*
import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.AchivmentsEntity
import online.jutter.cow.data.db.ent.UserAchivmentEntity

object AchivmentsRepository : BaseRepository<AchivmentsEntity>() {

    fun setAll(achivments: List<AchivmentsEntity>) = executeTransaction {
        removeAllInstances(AchivmentsEntity::class.java)
        removeAllInstances(UserAchivmentEntity::class.java)

        for (item in achivments) {
            persist(item)
        }
    }

    fun getAllUserAchivments(userId: String) = executeTransaction {
        getQuery<UserAchivmentEntity>("user" eq userId)
    }

    fun giveAchivment(icon: String, userId: String) = executeTransaction {
        val achivment = getQuery<AchivmentsEntity>("icon" eq icon).first()
        val userAchivment = getQuery<UserAchivmentEntity>(("user" eq userId) and ("achivment" eq achivment.id)).firstOrNull()
        if (userAchivment == null) {
            persist(
                UserAchivmentEntity().apply {
                    this.id = getUUID()
                    this.user = userId
                    this.achivment = achivment.id
                }
            )
        }
    }
}