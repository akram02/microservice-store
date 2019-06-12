package com.example.auth

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping("/")
    fun getJWTConfigData(): String{
        with(JwtConfig()) {
            return "$Uri $Expiration $Header $Prefix $Secret"
        }
    }
}
