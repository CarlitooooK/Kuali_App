package com.example.kuali_app.inter

import com.example.kuali_app.models.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenFoodFactsApi {
    @GET("search")
    suspend fun getProducts(
        @Query("categories_tags") category: String = "supermarket",
        @Query("countries_tags") country: String = "mexico",
        @Query("fields") fields:String = "product_name,image_front_url",
        @Query("sort_by") sortBy: String = "popularity_key",
        @Query("page_size") pageSize:Int=20
    ): ProductResponse
}