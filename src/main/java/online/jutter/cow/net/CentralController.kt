package online.jutter.cow.net

import online.jutter.cow.common.TokenManager
import online.jutter.cow.common.ext.createWrapperResponse

import online.jutter.cow.domain.uscaseses.news.GetCentralUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(
        value = ["api/news/central"],
        produces = ["application/json; charset=utf-8"]
)
class CentralController {

    private val getCentralUseCase = GetCentralUseCase()

    @RequestMapping(
        value = ["getCentral"],
        method = [RequestMethod.GET]
    )
    fun get(
        @RequestHeader("Authorization") token: String,
    ) = createWrapperResponse {
        TokenManager.verifyToken(token)
        getCentralUseCase(TokenManager.getIdFromToken(token))
    }


}