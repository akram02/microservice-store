package com.example.product.model

import javax.persistence.*
import java.math.BigDecimal

@Entity
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var name: String = "",
        var description: String = "",
        var imageUrl: String = "",
        var price: Double = 0.0,
        var size: String = ""
)
