package com.example.product

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import javax.sql.DataSource
import java.sql.DatabaseMetaData
import java.sql.SQLException

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DatabaseHealthTest {
    @Autowired
    lateinit var dataSource: DataSource

    @Test
    fun dbConnectionIsOk() {
        try {
            val metaData = dataSource.connection.metaData
            val catalogName = dataSource.connection.catalog

            assertThat(metaData, `is`(notNullValue()))
            assertThat(catalogName, `is`(equalTo("product")))
        } catch (e: SQLException) {
            e.printStackTrace()
        }

    }
}
