package online.jutter.cow.net

import online.jutter.cow.common.ext.createWrapperResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
        value = ["api/hello"],
        produces = ["application/json; charset=utf-8"]
)
class HelloController {

    @RequestMapping(
        value = ["say"],
        method = [RequestMethod.GET]
    )
    fun get() = createWrapperResponse {
        "hello"
    }
}