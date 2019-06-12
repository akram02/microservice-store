package com.example.product.repository

import com.example.product.model.Product
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.transaction.TransactionalTestExecutionListener

import com.github.springtestdbunit.DbUnitTestExecutionListener
import com.github.springtestdbunit.annotation.DatabaseSetup


@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@TestExecutionListeners(DependencyInjectionTestExecutionListener::class, DirtiesContextTestExecutionListener::class, TransactionalTestExecutionListener::class, DbUnitTestExecutionListener::class)
//@DatabaseSetup("classpath:test-datasets.xml")
class ProductRepositoryUT {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var productRepository: ProductRepository

//    @Test
//    fun findByName() {
//        val product = productRepository.findByName("product 1")
//        assertThat(product.id, `is`(equalTo(1L)))
//    }

    @Test
    fun findByPrimaryKey() {
        val product = entityManager.find(Product::class.java, "1".toLong())
        assertThat(product.name, `is`(equalTo("Book")))
    }
}
