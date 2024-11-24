package online.jutter.cow.domain.uscaseses.user

import online.jutter.cow.common.TokenManager
import online.jutter.cow.common.ext.getUUID
import online.jutter.cow.data.db.ent.UserEntity
import online.jutter.cow.data.db.repositories.UsersRepository
import online.jutter.cow.data.models.auth.LoginResponse
import online.jutter.cow.data.models.auth.RegisterRequest
import online.jutter.cow.domain.uscaseses.notification.SendNotificationUseCase

class RegisterNewUserUseCase {

    private val sendNotificationUseCase = SendNotificationUseCase()
    operator fun invoke(registerRequest: RegisterRequest): LoginResponse {
        val user = UsersRepository.getByLogin(registerRequest.login)
        if (user != null) throw error("Пользователь уже зарегистрирован")
        val id = getUUID()
        val userEntity = UserEntity().apply {
            this.id = id
            this.login = registerRequest.login
            this.name = registerRequest.name
            this.lastname = registerRequest.lastname
            this.midname = registerRequest.midname
            this.avatar = registerRequest.avatarUrl
            this.coins = 125
            this.companyRole = "Читатель"
        }
        UsersRepository.insert(userEntity)
        sendNotificationUseCase(
            id,
            "Добро пожаловать!",
            "Мы рады видеть вас в нашем приложении, и в честь этого мы приготовили небольшой подарок, а именно 125 листиков, которые вы сможете обменять на подарки",
        )
        return LoginResponse(TokenManager.getToken(userEntity), true)
    }
}