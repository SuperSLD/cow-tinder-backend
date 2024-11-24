package online.jutter.cow.net

import online.jutter.cow.common.TokenManager
import online.jutter.cow.common.ext.createEmptyWrapperResponse
import online.jutter.cow.common.ext.createWrapperResponse
import online.jutter.cow.data.models.AddCowRequest
import online.jutter.cow.data.models.auth.LoginRequest
import online.jutter.cow.domain.uscaseses.cows.AddCowUseCase
import online.jutter.cow.domain.uscaseses.cows.FindCowByIdUseCase
import online.jutter.cow.domain.uscaseses.cows.GetAllCowsUseCase
import online.jutter.cow.domain.uscaseses.user.UserLoginUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
        value = ["api/cow"],
        produces = ["application/json; charset=utf-8"]
)
class CowController {

    private val findCowByIdUseCase = FindCowByIdUseCase()
    private val getAllCowsUseCase = GetAllCowsUseCase()
    private val addCowsUseCase = AddCowUseCase()

    @RequestMapping(
        value = ["find/{id}"],
        method = [RequestMethod.GET]
    )
    fun find(
        @RequestHeader("Authorization") token: String,
        @PathVariable id: String,
    ) = createWrapperResponse {
        TokenManager.verifyToken(token)
        findCowByIdUseCase(id)
    }

    @RequestMapping(
        value = ["all"],
        method = [RequestMethod.GET]
    )
    fun getAll(
        @RequestHeader("Authorization") token: String,
    ) = createWrapperResponse {
        TokenManager.verifyToken(token)
        getAllCowsUseCase()
    }

    @RequestMapping(
        value = ["addcow"],
        method = [RequestMethod.POST]
    )
    fun addCow(
        @RequestBody addCowRequest: AddCowRequest,
    ) = createWrapperResponse {
        addCowsUseCase(addCowRequest)
    }
}