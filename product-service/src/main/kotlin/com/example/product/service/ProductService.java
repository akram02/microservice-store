package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.vm.ProductVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product addProduct(Product product) {
        Product newProduct = null;
        if (!product.getName().equals("")) {
            newProduct = productRepository.save(product);
        }
        return newProduct;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
