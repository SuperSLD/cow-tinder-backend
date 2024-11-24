package online.jutter.cow.domain.uscaseses.achivments

import online.jutter.cow.data.db.repositories.AchivmentsRepository

class GiveUserAchivmentUseCase {

    operator fun invoke(icon: String, userId: String) {
        AchivmentsRepository.giveAchivment(icon, userId)
    }
}