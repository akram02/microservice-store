package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public String processSubmittedProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);

        if (newProduct != null) {
            return "New product added successfully";
        }
        return "Something went wrong";
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        log.debug("REST request to get all Products");
        return productService.getAllProduct();
    }
}
