package com.moralabs.istegelsin.data.remote.api

import com.moralabs.istegelsin.data.remote.dto.CategoryResponse
import com.moralabs.istegelsin.data.remote.dto.ProductResponse
import retrofit2.Response
import retrofit2.http.*

interface MainApi {

    @GET("market/category/template")
    suspend fun getCategories() : Response<CategoryResponse>

    @POST("market/product/template")
    suspend fun getProducts(@Body request: DetailsRequest) : Response<ProductResponse>

}