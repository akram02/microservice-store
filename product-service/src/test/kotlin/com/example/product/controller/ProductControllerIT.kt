package com.example.product.controller

import com.example.product.model.Product
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerIT {

    @Autowired
    lateinit var productController: ProductController

    @Test
    fun processSubmittedProductWithoutName() {
        val product = Product()
        product.description = "Description without a product name"

        val outcome = productController.processSubmittedProduct(product)
        assertThat(outcome, `is`(equalTo("Something went wrong")))
    }

    @Test
    fun processSubmittedProduct() {
        val product = Product()
        product.name = "Test Product"
        product.description = "Product from ProductController Integration test"

        val outcome = productController.processSubmittedProduct(product)
        assertThat(outcome, `is`(equalTo("New product added successfully")))
    }
}
