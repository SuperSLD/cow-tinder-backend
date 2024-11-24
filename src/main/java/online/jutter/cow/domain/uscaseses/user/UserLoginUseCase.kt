package online.jutter.cow.domain.uscaseses.user

import online.jutter.cow.common.TokenManager
import online.jutter.cow.data.db.repositories.UsersRepository
import online.jutter.cow.data.models.auth.LoginResponse
import online.jutter.cow.domain.uscaseses.achivments.GiveUserAchivmentUseCase

class UserLoginUseCase {

    private val giveUserAchivmentUseCase = GiveUserAchivmentUseCase()

    operator fun invoke(login: String): LoginResponse {
        val user = UsersRepository.getByLogin(login) ?: return LoginResponse(null, false)
        val token = TokenManager.getToken(user)
        giveUserAchivmentUseCase("authorisation", user.id)
        return LoginResponse(token, true)
    }
}