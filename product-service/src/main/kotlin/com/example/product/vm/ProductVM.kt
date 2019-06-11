package com.example.product.vm

data class ProductVM(
        var name: String = "",
        var description: String = "",
        var imageUrl: String = "",
        var price: Double = 0.0,
        var size: String = ""
)