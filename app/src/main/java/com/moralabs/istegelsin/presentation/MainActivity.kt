package com.moralabs.istegelsin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.moralabs.istegelsin.databinding.ActivityMainBinding
import com.moralabs.istegelsin.domain.entity.Category
import com.moralabs.istegelsin.domain.entity.Product
import com.moralabs.istegelsin.presentation.category.CategoryAdapter
import com.moralabs.istegelsin.presentation.product.ProductAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel = get()
    private val mCategoryList = mutableListOf<Category>()
    private val mProductList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            mainViewModel.mainState.collect { mainUiState ->
                when(mainUiState) {
                    is MainUiState.Success -> {
                        mainUiState.mainEntity.categories.let{
                            if(mCategoryList.isEmpty()){
                                mCategoryList.addAll(it)
                                binding.categoriesRecycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.HORIZONTAL, false)
                                binding.categoriesRecycler.adapter = CategoryAdapter(mCategoryList, applicationContext, binding, "category", mainViewModel)
                            }
                        }

                        mProductList.clear()
                        mainUiState.mainEntity.products.forEachIndexed { _, product ->
                            mProductList.add(product)
                        }
                        binding.productsRecycler.layoutManager = GridLayoutManager(applicationContext, 3)
                        binding.productsRecycler.adapter = ProductAdapter( mProductList)

                    }
                }
            }
        }

        mainViewModel.getLists()
    }
}