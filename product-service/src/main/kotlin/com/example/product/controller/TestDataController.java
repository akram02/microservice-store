package com.example.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
@RequestMapping("/test")
public class TestDataController {

    @Value("${catalog.sample.data: Akram}")
    private String data;

    @GetMapping("/")
    private String getData() {
        return data;
    }
}
