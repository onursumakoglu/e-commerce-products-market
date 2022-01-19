package com.moralabs.istegelsin.domain.usecase

import com.moralabs.istegelsin.data.remote.dto.CategoryResponse
import com.moralabs.istegelsin.data.remote.dto.ProductResponse
import com.moralabs.istegelsin.data.remote.repository.MainRepository
import com.moralabs.istegelsin.domain.common.BaseResult
import com.moralabs.istegelsin.domain.entity.MainEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainUseCase(private val mainRepository: MainRepository) {

    var categoryId = "A"

    fun starProcess(): Flow<BaseResult<MainEntity, CategoryResponse>> {
        return flow {

            emit(
                BaseResult.Success(
                    MainEntity(
                        categories = mainRepository.getCategories(categoryId)
                    )
                )
            )

        }
    }


}