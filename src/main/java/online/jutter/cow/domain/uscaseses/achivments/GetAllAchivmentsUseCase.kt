package online.jutter.cow.domain.uscaseses.achivments

import online.jutter.cow.data.db.repositories.AchivmentsRepository
import online.jutter.cow.domain.models.AchivmentResponse

class GetAllAchivmentsUseCase {

    operator fun invoke(userId: String): List<AchivmentResponse> {
        val achivments = AchivmentsRepository.getAll()
        val userAchivments = AchivmentsRepository.getAllUserAchivments(userId)

        return achivments.map { ach ->
            AchivmentResponse(
                id = ach.id,
                title = ach.title,
                description = ach.description,
                icon = ach.icon,
                isDone = userAchivments?.find { it.achivment == ach.id } != null
            )
        }
    }
}