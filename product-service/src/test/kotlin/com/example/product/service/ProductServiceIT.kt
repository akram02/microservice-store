package com.example.product.service

import com.example.product.model.Product
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProductServiceIT {
    @Autowired
    lateinit var productService: ProductService

    @Test
    fun addProduct() {
        val product = Product(0, "Book", "Harry Poter", "http://..", 50.0, "Large")
        val newProduct = productService.addProduct(product)
        assertNotNull(newProduct)
        assertNotNull(newProduct.id)
        assertEquals("Harry Poter", newProduct.description)
    }
}