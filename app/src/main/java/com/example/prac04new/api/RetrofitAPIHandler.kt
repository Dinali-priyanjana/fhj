package com.example.prac04new.api

import android.telecom.Call
import com.example.prac04new.models.Photo

interface RetrofitAPIHandler {

    @GET("photos")
    fun getphotos(): Call<List<Photo>>
    companion object{
        val API_URL = "https://jsonplaceholder.typicode.com"
        fun cretae() {
            val retrofit = Retrofit.Builder()
                .addcon
        }
    }
}

