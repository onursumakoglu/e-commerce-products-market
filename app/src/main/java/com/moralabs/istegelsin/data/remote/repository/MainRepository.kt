package com.moralabs.istegelsin.data.remote.repository

import com.moralabs.istegelsin.data.remote.api.DetailsRequest
import com.moralabs.istegelsin.domain.entity.Category
import com.moralabs.istegelsin.domain.entity.Product

interface MainRepository {
    suspend fun getCategories(): List<Category>
    suspend fun getProducts(requestBody: DetailsRequest): List<Product>
}