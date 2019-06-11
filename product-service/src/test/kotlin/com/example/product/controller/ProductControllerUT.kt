package com.example.product.controller

import com.example.product.model.Product
import com.example.product.service.ProductService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(ProductController::class)
class ProductControllerUT {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var productService: ProductService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun processSubmittedProduct() {
        val mockProduct = Product()
        mockProduct.name = "Mock Product"

        `when`(productService.addProduct(any(Product::class.java))).thenReturn(mockProduct)

        val newProduct = Product()
        newProduct.name = "New product name"
        newProduct.description = "New product description"

        mockMvc
                .perform(
                        post("/add")
                                .content(ObjectMapper().writeValueAsBytes(newProduct))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk)
                .andExpect(content().string("New product added successfully"))
                .andReturn()
    }

    @Test
    @Throws(Exception::class)
    fun processSubmittedProductReturnNull() {

        `when`(productService.addProduct(any(Product::class.java))).thenReturn(null)

        val newProduct = Product()
        newProduct.name = "New product name"
        newProduct.description = "New product description"

        mockMvc
                .perform(
                        post("/add")
                                .content(ObjectMapper().writeValueAsBytes(newProduct))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk)
                .andExpect(content().string("Something went wrong"))
                .andReturn()
    }
}
