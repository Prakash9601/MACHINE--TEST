package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity(tableName = "Category")
class Category {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var title: String? = null
    @TypeConverters(ProductStringTypeConverter::class)
    var product: ArrayList<Product>? = ArrayList()
}
