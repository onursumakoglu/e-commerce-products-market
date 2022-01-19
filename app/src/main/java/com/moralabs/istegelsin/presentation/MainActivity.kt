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
            mainViewModel.mainState.collect { mainUiState ->
                when(mainUiState) {
                    is MainUiState.Success -> {
                        val categoryList = mutableListOf<CategoryList>()

                        mainUiState.mainEntity.categories.forEachIndexed { index, category ->
                            categoryList.add(CategoryList(mutableListOf(category)))
                        }

                        mList.addAll(categoryList)

                        println(mList)

                    }
                }
            }
        }

        mainViewModel.getProductList()



        /*
        fragment_home_main_page_walkthroughs_and_hints.recycler.bind<ListItemTipBinding, Tip>(
            owner = activity!!,
            data = DataStorageService.shared.tips.featured,
            layoutId = R.layout.list_item_tip,
            modelId = BR.model,
            isInfinite = false
        ) { activity?.openTipActivity(it.id) }

         */

    }

}