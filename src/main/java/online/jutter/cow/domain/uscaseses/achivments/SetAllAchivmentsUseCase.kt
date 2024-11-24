package online.jutter.cow.domain.uscaseses.achivments

import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.AchivmentsEntity
import online.jutter.cow.data.db.repositories.AchivmentsRepository
import online.jutter.cow.domain.models.Achivment

class SetAllAchivmentsUseCase {

    operator fun invoke(achivments: List<Achivment>) {
        AchivmentsRepository.setAll(achivments.map { mapToEnt(it) })
    }

    fun mapToEnt(achivment: Achivment) =
       AchivmentsEntity().apply {
           this.id = getUUID()
           this.title = achivment.title
           this.description = achivment.description
           this.icon = achivment.icon
       }
}