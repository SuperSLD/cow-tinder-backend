package online.jutter.cow.net

import online.jutter.cow.common.TokenManager
import online.jutter.cow.common.ext.createWrapperResponse
import online.jutter.cow.data.models.auth.LoginRequest
import online.jutter.cow.data.models.auth.RegisterRequest
import online.jutter.cow.domain.uscaseses.user.GetInfoUseCase
import online.jutter.cow.domain.uscaseses.user.RegisterNewUserUseCase
import online.jutter.cow.domain.uscaseses.user.UserLoginUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
        value = ["api/auth"],
        produces = ["application/json; charset=utf-8"]
)
class AuthorisationController {

    private val userLoginUseCase = UserLoginUseCase()
    private val registerNewUserUseCase = RegisterNewUserUseCase()
    private val getInfoUseCase = GetInfoUseCase()

    @RequestMapping(
        value = ["login"],
        method = [RequestMethod.POST]
    )
    fun login(
        @RequestBody loginRequest: LoginRequest,
    ) = createWrapperResponse {
        userLoginUseCase(loginRequest.login!!)
    }

    @RequestMapping(
        value = ["register"],
        method = [RequestMethod.POST]
    )
    fun register(
        @RequestBody registerRequest: RegisterRequest,
    ) = createWrapperResponse {
        registerNewUserUseCase(registerRequest)
    }

    @RequestMapping(
            value = ["getInfo"],
            method = [RequestMethod.GET]
    )
    fun getInfo(
            @RequestHeader("Authorization") token: String,
    ) = createWrapperResponse {
        TokenManager.verifyToken(token)
        getInfoUseCase(TokenManager.getIdFromToken(token))

    }
}