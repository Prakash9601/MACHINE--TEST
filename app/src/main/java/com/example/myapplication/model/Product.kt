package com.example.myapplication.model

import java.io.Serializable


data class Product(
    var title: String? = null,
    var price: Int? = null,
    var imageUrl: String? = null,
    var description: String? = null
): Serializable

