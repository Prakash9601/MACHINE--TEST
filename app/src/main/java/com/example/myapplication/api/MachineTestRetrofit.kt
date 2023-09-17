package com.example.myapplication.api



import com.example.myapplication.model.Example
import com.example.myapplication.utils.Const.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface MachineTestRetrofit {
    @GET("5ec39cba300000720039c1f6")
    fun getProduct(): Call<Example?>?

    companion object {
        fun create(): MachineTestRetrofit {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MachineTestRetrofit::class.java)
        }
    }
}