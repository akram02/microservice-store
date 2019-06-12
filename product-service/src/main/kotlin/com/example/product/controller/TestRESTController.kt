package com.bookstore.catalogservice.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping


@RestController
@RequestMapping("/api/test")
@RefreshScope
class TestRESTController {
    var logger = LoggerFactory.getLogger(this.javaClass)
    @Value("\${catalog.sample.data}")
    private val data: String? = null
    val sampleData: String?
        @GetMapping("/getSampleData") get() {
            logger.info(" sample data value is -->" + this.data!!)
            return this.data
        }
}