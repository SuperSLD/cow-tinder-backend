package online.jutter.cow.net

import com.example.app_domain.models.cow.CowPairData
import online.jutter.cow.common.TokenManager
import online.jutter.cow.common.ext.createWrapperResponse
import online.jutter.cow.data.models.CowRequest
import online.jutter.cow.domain.uscaseses.cows.AddCowUseCase
import online.jutter.cow.domain.uscaseses.cows.FindCowByIdUseCase
import online.jutter.cow.domain.uscaseses.cows.FindCowPairByIdUseCase
import online.jutter.cow.domain.uscaseses.cows.GetAllCowsUseCase
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
    private val findCowPairByIdUseCase = FindCowPairByIdUseCase()

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
        @RequestBody addCowRequest: CowRequest,
    ) = createWrapperResponse {
        addCowsUseCase(addCowRequest)
    }

    @RequestMapping(
        value = ["findpair"],
        method = [RequestMethod.POST]
    )
    fun findPair(
        @RequestHeader("Authorization") token: String,
        @RequestBody cowPairData: CowPairData,
    ) = createWrapperResponse {
        TokenManager.verifyToken(token)
        findCowPairByIdUseCase(cowPairData.cowTag, cowPairData.maximisationParam)
    }
}