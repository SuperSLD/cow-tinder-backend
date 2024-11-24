package online.jutter.cow.data.db.repositories

import online.jutter.cow.data.db.*
import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.AchivmentsEntity
import online.jutter.cow.data.db.ent.NotificationEntity
import online.jutter.cow.data.db.ent.UserAchivmentEntity
import online.jutter.cow.domain.models.notification.Notification

object NotificationsRepository : BaseRepository<AchivmentsEntity>() {

    fun setAll(achivments: List<AchivmentsEntity>) = executeTransaction {
        removeAllInstances(AchivmentsEntity::class.java)
        removeAllInstances(UserAchivmentEntity::class.java)

        for (item in achivments) {
            persist(item)
        }
    }

    fun getAllUserNotifications(userId: String) = executeTransaction {
        getQuery<NotificationEntity>("user" eq userId)
    }

    fun addNotification(notification: Notification) = executeTransaction {
        persist(
            NotificationEntity().apply {
                this.id = getUUID()
                this.text = notification.text
                this.title = notification.title
                this.user = notification.user
                this.bookId = notification.boock
                this.eventId = notification.event
                this.type = notification.type
            }
        )
    }
}