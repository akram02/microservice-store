package com.example.zuulgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
class ZuulGatewayApplication

fun main(args: Array<String>) {
    runApplication<ZuulGatewayApplication>(*args)
}
