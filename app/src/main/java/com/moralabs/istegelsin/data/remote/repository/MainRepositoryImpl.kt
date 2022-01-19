package com.moralabs.istegelsin.data.remote.repository

import com.moralabs.istegelsin.data.remote.api.MainApi
import com.moralabs.istegelsin.domain.entity.Category
import com.moralabs.istegelsin.domain.entity.Product

class MainRepositoryImpl(private var mainApi: MainApi): MainRepository {

    override suspend fun getCategories(categoryId: String): List<Category> {
        val response = mainApi.getCategories(
            "BFD7CFDB-F825-4D9A-EFD2-08D9BF1326C6",
            "CA3CCECF-B93B-41A6-BD84-F7CBB515AA54",
            categoryId)

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

}