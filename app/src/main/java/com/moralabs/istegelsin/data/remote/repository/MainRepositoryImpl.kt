package com.moralabs.istegelsin.data.remote.repository

import com.moralabs.istegelsin.data.remote.api.DetailsRequest
import com.moralabs.istegelsin.data.remote.api.MainApi
import com.moralabs.istegelsin.domain.entity.Category
import com.moralabs.istegelsin.domain.entity.Product

class MainRepositoryImpl(private var mainApi: MainApi): MainRepository {

    override suspend fun getCategories(): List<Category> {

        val response = mainApi.getCategories()

        if (response.isSuccessful){

            println(response.body())

            return response.body()?.categories?.map {
                Category(
                    id = it.id,
                    parentCategoryID = it.parentCategoryID,
                    name = it.name,
                    subcategories = it.subcategories
                )
            } ?: listOf()

        }
        return listOf()

    }

    override suspend fun getProducts(): List<Product> {
        TODO("Not yet implemented")
    }


}