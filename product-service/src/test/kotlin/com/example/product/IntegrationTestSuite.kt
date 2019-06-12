package com.example.product

import com.example.product.controller.ProductControllerIT
import com.example.product.repository.ProductRepositoryIT
import com.example.product.service.ProductServiceIT
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
        ProductRepositoryIT::class,
        ProductServiceIT::class,
        ProductControllerIT::class
)
class IntegrationTestSuite


