package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerUT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void processSubmittedProduct() throws Exception {
        Product mockProduct = new Product();
        mockProduct.setName("Mock Product");

        when(productService.addProduct(any(Product.class))).thenReturn(mockProduct);

        Product newProduct = new Product();
        newProduct.setName("New product name");
        newProduct.setDescription("New product description");

        mockMvc
                .perform(
                        post("/add")
                                .content(new ObjectMapper().writeValueAsBytes(newProduct))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())

                //TODO works without name!!
                .andExpect(content().string("New product added successfully"))
                .andReturn();
    }
}
