package com.example.product

import com.example.product.controller.ProductControllerUT
import com.example.product.repository.ProductRepositoryUT
import com.example.product.service.ProductServiceUT
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
        ProductRepositoryUT::class,
        ProductServiceUT::class,
        ProductControllerUT::class
)
class UnitTestSuite
