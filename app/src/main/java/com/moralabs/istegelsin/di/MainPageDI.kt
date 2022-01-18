package com.moralabs.istegelsin.di

import com.moralabs.istegelsin.data.remote.api.MainApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPageDI {
    companion object{

        val module = module {

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

            

        }

    }
}

/*
val module = module {

    //viewModel { HomeViewModel(get()) }

    single <MainApi> {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        retrofit.create(MainApi::class.java)
    }

    //single<HomeRepository> { HomeRepositoryImpl(get(), get()) }

    //single { HomeUseCase(get()) }


}



 */