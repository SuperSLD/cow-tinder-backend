package online.jutter.cow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
open class CowApplication: SpringBootServletInitializer() {
    @Bean
    open fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry?) {
                registry!!.addMapping("/**").allowedOrigins("*")
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<CowApplication>(*args)
}
