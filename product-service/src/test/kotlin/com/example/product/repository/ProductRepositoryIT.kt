package com.example.product.repository

import com.example.product.model.Product
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryIT {

    @Autowired
    lateinit var testEntityManager: TestEntityManager

    @Autowired
    lateinit var productRepository: ProductRepository

    @Test
    fun findByName() {
        val product = Product()
        val name = "NEW_NAME_ONLY_FOR_PRODUCT_REPOSITORY_IT"
        product.name = name

        testEntityManager.persist(product)

        var foundProduct = productRepository.findByName(name)
        assertThat(foundProduct.name, `is`(equalTo(name)))

        productRepository.deleteById(foundProduct.id)
        foundProduct = productRepository.findByName(name)
        assertNull(foundProduct)
    }
}
