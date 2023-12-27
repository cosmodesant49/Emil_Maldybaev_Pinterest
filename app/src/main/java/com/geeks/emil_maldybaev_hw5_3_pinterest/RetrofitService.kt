package com.geeks.emil_maldybaev_hw5_3_pinterest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api = retrofit.create(PixaApi::class.java)
}