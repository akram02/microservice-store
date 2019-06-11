package com.example.registry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class RegistryServiceApplication

fun main(args: Array<String>) {
    runApplication<RegistryServiceApplication>(*args)
}
