package com.example.product.service

import com.example.product.model.Product
import com.example.product.repository.ProductRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest

import org.junit.Assert.assertEquals
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`

@RunWith(MockitoJUnitRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProductServiceUT {

    @Mock
    lateinit var productRepository: ProductRepository

    @InjectMocks
    lateinit var productService: ProductService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun addProduct() {
        val product = Product()
        product.name = "Pen"
        product.description = "Jononi"

        `when`(productRepository.save(any(Product::class.java))).thenReturn(product)

        val (_, name) = productService.addProduct(Product(name = "Nothing"))
        assertEquals("Pen", name)
    }
}
