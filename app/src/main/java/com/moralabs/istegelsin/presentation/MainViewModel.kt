package com.moralabs.istegelsin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moralabs.istegelsin.data.remote.api.DetailsRequest
import com.moralabs.istegelsin.domain.common.BaseResult
import com.moralabs.istegelsin.domain.entity.MainEntity
import com.moralabs.istegelsin.domain.usecase.MainUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(private val mainUseCase: MainUseCase): ViewModel() {

    private val uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState.Idle)
    val mainState: StateFlow<MainUiState> = uiState

    var requestBody1 = DetailsRequest(
    subCategoryID = "A",
    keyword = ""
    )

    fun getLists() {
        viewModelScope.launch {
            mainUseCase.starProcess(requestBody1)
                .onStart {
                    uiState.value = MainUiState.Loading
                }
                .collect { baseResult ->
                    when(baseResult){
                        is BaseResult.Success -> uiState.value = MainUiState.Success(baseResult.data)
                    }
                }
        }
    }

    fun getProducts(requestBody: DetailsRequest) {
        viewModelScope.launch {
            mainUseCase.starProcess(requestBody)
                .onStart {
                    uiState.value = MainUiState.Loading
                }
                .collect { baseResult ->
                    when(baseResult){
                        is BaseResult.Success -> uiState.value = MainUiState.Success(baseResult.data)
                    }
                }
        }
    }

}

sealed class MainUiState {
    data class Success(val mainEntity: MainEntity): MainUiState()
    object Idle : MainUiState()
    object Loading : MainUiState()
}
