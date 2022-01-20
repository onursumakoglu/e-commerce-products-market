package com.moralabs.istegelsin.presentation.category

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moralabs.istegelsin.R
import com.moralabs.istegelsin.data.remote.api.DetailsRequest
import com.moralabs.istegelsin.databinding.ActivityMainBinding
import com.moralabs.istegelsin.databinding.ItemCategoryBinding
import com.moralabs.istegelsin.databinding.ItemSubCategoryBinding
import com.moralabs.istegelsin.domain.entity.Category
import com.moralabs.istegelsin.presentation.MainViewModel

class CategoryAdapter(private val list: List<Category>, val mainContext: Context, val mainBinding: ActivityMainBinding, val type: String, val mainViewModel: MainViewModel):
    RecyclerView.Adapter<CategoryAdapterViewHolder>() {

    var flag_index = -1
    var flag_index_sub = -1

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryAdapterViewHolder {

        when(p1) {
            R.layout.item_category -> {
                val binding = ItemCategoryBinding.inflate(LayoutInflater.from(p0.context), p0, false)
                return CategoryAdapterViewHolder.CategoryViewHolder(binding)
            }
            else -> { //R.layout.item_sub_category
                val binding = ItemSubCategoryBinding.inflate(LayoutInflater.from(p0.context), p0, false)
                return CategoryAdapterViewHolder.SubCategoryViewHolder(binding)
            }
        }

    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(p0: CategoryAdapterViewHolder, p1: Int) {
        when(p0){
            is CategoryAdapterViewHolder.CategoryViewHolder -> {
                p0.categoryItem.category = list[p1]

                p0.binding.setOnClickListener {
                    mainBinding.subCategoriesRecycler.visibility = View.VISIBLE
                    val subCategoryList = list[p1].subcategories as List<Category>

                    mainBinding.subCategoriesRecycler.layoutManager = LinearLayoutManager(mainContext, LinearLayout.HORIZONTAL, false)
                    mainBinding.subCategoriesRecycler.adapter = CategoryAdapter(subCategoryList, mainContext, mainBinding, "subCategory", mainViewModel)

                    val categoryId = list[p1].id

                    val requestBody = DetailsRequest(
                        subCategoryID = categoryId,
                        keyword = ""
                    )
                    mainViewModel.getProducts(requestBody)

                    flag_index = p1
                    notifyDataSetChanged()
                }
                if(flag_index == p1)
                    p0.categoryItem.categoryText.setTextColor(Color.BLUE);
                else
                    p0.categoryItem.categoryText.setTextColor(Color.BLACK);

            }
            is CategoryAdapterViewHolder.SubCategoryViewHolder -> {
                p0.subCategoryItem.subCategory = list[p1]

                p0.binding.setOnClickListener {
                    val subCategoryId = list[p1].id

                    val requestBody = DetailsRequest(
                        subCategoryID = subCategoryId,
                        keyword = ""
                    )
                    mainViewModel.getProducts(requestBody)

                    flag_index_sub = p1
                    notifyDataSetChanged()
                }
                if(flag_index_sub == p1)
                    p0.subCategoryItem.subCategoryCard.setBackgroundColor(Color.parseColor("#FFD7E0FF"))
                else
                    p0.subCategoryItem.subCategoryCard.setBackgroundColor(Color.parseColor("#FFF2F5FB"))

            }
        }

        searchAction()

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        when(type){
            "category" -> return R.layout.item_category
            "subCategory" -> return R.layout.item_sub_category
        }
        return R.layout.item_category
    }

    fun searchAction() {

        mainBinding.searchView.setOnClickListener { mainBinding.searchView.setIconified(false) }
        mainBinding.searchView.setQueryHint("Ürün Ara")

        mainBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                val requestBody: DetailsRequest
                if (p0 != null){
                    requestBody = DetailsRequest(
                        subCategoryID = "",
                        keyword = p0
                    )
                }
                else{
                    requestBody = DetailsRequest(
                        subCategoryID = "A",
                        keyword = ""
                    )
                }
                mainViewModel.getProducts(requestBody)
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })

    }

}