package com.geeks.emil_maldybaev_hw5_3_pinterest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    //https://pixabay.com/api/
    @GET("api/")
//maybe mistake key 28.50
    fun getImages(
        @Query("q") keyWord: String,
        @Query("key") key: String = "41483564-b740fcc1122e14cf31a932d03",
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 9,
    ): Call<PixaModel>
}