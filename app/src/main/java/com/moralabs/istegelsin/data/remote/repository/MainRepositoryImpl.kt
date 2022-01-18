package com.moralabs.istegelsin.data.remote.repository

import com.moralabs.istegelsin.data.remote.api.MainApi
import com.moralabs.istegelsin.domain.entity.Product

class MainRepositoryImpl(private var mainApi: MainApi): MainRepository {

    override suspend fun getProducts(categoryId: String): List<Product> {
        val response = mainApi.getProducts(
            "BFD7CFDB-F825-4D9A-EFD2-08D9BF1326C6",
            "CA3CCECF-B93B-41A6-BD84-F7CBB515AA54",
            categoryId)

        if (response.isSuccessful){

            println("buradyız")
            println(response.body())

            return response.body()?.products?.map {
                Product(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.imageUrl,
                    price = it.price,
                    promotionDiscountPercentage = it.promotionDiscountPercentage
                )
            } ?: listOf()

        }
        return listOf()

    }

}