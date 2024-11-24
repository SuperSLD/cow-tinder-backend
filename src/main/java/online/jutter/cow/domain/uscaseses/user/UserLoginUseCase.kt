package online.jutter.cow.domain.uscaseses.user

import online.jutter.cow.common.TokenManager
import online.jutter.cow.data.db.repositories.UsersRepository
import online.jutter.cow.data.models.auth.LoginResponse

class UserLoginUseCase {

    operator fun invoke(login: String, password: String): String {
        val user = UsersRepository.getByLogin(login) ?: throw error("Нет в системе")
        if (user.pin != password) throw error("Неправильный пин")
        val token = TokenManager.getToken(user)
        return token
    }
}