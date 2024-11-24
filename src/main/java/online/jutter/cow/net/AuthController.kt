package online.jutter.cow.net

import online.jutter.cow.common.TokenManager
import online.jutter.cow.common.ext.createEmptyWrapperResponse
import online.jutter.cow.common.ext.createWrapperResponse
import online.jutter.cow.data.models.auth.LoginRequest
import online.jutter.cow.domain.uscaseses.user.UserLoginUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
        value = ["api/auth"],
        produces = ["application/json; charset=utf-8"]
)
class AuthController {

    private val userLoginUseCase = UserLoginUseCase()

    @RequestMapping(
        value = ["login"],
        method = [RequestMethod.POST]
    )
    fun get(
        @RequestBody loginRequest: LoginRequest,
    ) = createWrapperResponse {
        userLoginUseCase(loginRequest.login!!, loginRequest.password!!)
    }
}