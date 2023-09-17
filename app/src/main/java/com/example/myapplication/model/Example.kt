package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable



class Example : Serializable{
    @SerializedName("status")
    @Expose
    var status: Boolean? = null

    @SerializedName("msg")
    @Expose
    var msg: String? = null

    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null

    inner class Category : Serializable{
        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("products")
        @Expose
        var products: List<Product>? = null
    }

    inner class Product : Serializable {
        @SerializedName("title")
        @Expose
        var title: String? = null

        @SerializedName("price")
        @Expose
        var price: Int? = null

        @SerializedName("imageUrl")
        @Expose
        var imageUrl: String? = null

        @SerializedName("description")
        @Expose
        var description: String? = null
    }
}