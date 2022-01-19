package com.moralabs.istegelsin.di

import com.moralabs.istegelsin.data.remote.api.MainApi
import com.moralabs.istegelsin.data.remote.repository.MainRepository
import com.moralabs.istegelsin.data.remote.repository.MainRepositoryImpl
import com.moralabs.istegelsin.domain.usecase.MainUseCase
import com.moralabs.istegelsin.presentation.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPageDI {
    companion object{

        val appModule = module {

            viewModel { MainViewModel(get()) }

            single <MainApi> {

                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://apitest.pazarama.com")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofit.create(MainApi::class.java)
            }

            single<MainRepository> { MainRepositoryImpl(get()) }

            single { MainUseCase(get()) }

        }

    }
}