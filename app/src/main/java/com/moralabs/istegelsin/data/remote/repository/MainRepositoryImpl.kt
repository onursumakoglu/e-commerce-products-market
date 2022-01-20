package com.moralabs.istegelsin.data.remote.repository

import com.moralabs.istegelsin.data.remote.api.DetailsRequest
import com.moralabs.istegelsin.data.remote.api.MainApi
import com.moralabs.istegelsin.domain.entity.Category
import com.moralabs.istegelsin.domain.entity.Product

class MainRepositoryImpl(private var mainApi: MainApi): MainRepository {

    override suspend fun getCategories(): List<Category> {
        val response = mainApi.getCategories()
        if (response.isSuccessful){

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

    override suspend fun getProducts(requestBody: DetailsRequest): List<Product> {
        val response = mainApi.getProducts(requestBody)

        if (response.isSuccessful){

            return response.body()?.products!!.map {
                Product(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.imageUrl,
                    price = it.price,
                    promotionDiscountPercentage = it.promotionDiscountPercentage,
                    basket = 0
                )
            }
        }

        return listOf()

    }

}