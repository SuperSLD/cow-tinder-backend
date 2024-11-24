package online.jutter.cow.domain.uscaseses.user

import online.jutter.cow.data.db.repositories.UsersRepository
import online.jutter.cow.domain.models.UserResponse
import online.jutter.cow.domain.uscaseses.achivments.GetAllAchivmentsUseCase
import online.jutter.cow.domain.uscaseses.notification.GetUserNotificationsUseCase

class GetInfoUseCase {

    private val getAllAchivmentsUseCase = GetAllAchivmentsUseCase()
    private val getUserNotificationsUseCase = GetUserNotificationsUseCase()

    operator fun invoke(id: String): UserResponse {
        val user = UsersRepository.getById(id)!!
        return UserResponse(
            id = user.id,
            name = user.name,
            lastname = user.lastname,
            midname = user.midname,
            companyRole = user.companyRole,
            coins = user.coins,
            avatar = user.avatar,
            achivements = getAllAchivmentsUseCase(user.id),
            notifications = getUserNotificationsUseCase(id)
        )
    }
}