package com.moralabs.istegelsin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.moralabs.istegelsin.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel = get()
    private val mList = mutableListOf<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = mainViewModel

        lifecycleScope.launch {
            println("başarılı3")
            mainViewModel.mainState.collect { mainUiState ->
                println("başarılı2")
                println(mainUiState)
                when(mainUiState) {
                    is MainUiState.Success -> {

                        println("başarılı")

                        val productList = mutableListOf<ProductList>()

                        mainUiState.mainEntity.products.forEachIndexed { index, product ->
                            productList.add(ProductList(mutableListOf(product)))
                        }



                        mList.addAll(productList)

                        println(mList)

                    }
                }
            }
        }

        mainViewModel.getProductList()

    }

}