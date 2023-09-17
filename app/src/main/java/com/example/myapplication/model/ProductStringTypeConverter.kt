package com.example.myapplication.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ProductStringTypeConverter {

    @TypeConverter
    fun storedMaterialToList(value: String): ArrayList<Product> {
        val listType: Type = object : TypeToken<ArrayList<Product?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun materialToStoredString(materials: ArrayList<Product>?): String {
        if (materials == null) {
            return "[]"
        }
        val gson = Gson()
        return gson.toJson(materials)
    }
}