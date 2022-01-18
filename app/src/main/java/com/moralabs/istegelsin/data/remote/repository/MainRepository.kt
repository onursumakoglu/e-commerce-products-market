package com.moralabs.istegelsin.data.remote.repository

import com.moralabs.istegelsin.domain.entity.Product

interface MainRepository {
    suspend fun getProducts(categoryId: String): List<Product>
}