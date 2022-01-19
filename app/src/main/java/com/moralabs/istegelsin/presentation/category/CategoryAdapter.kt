package com.moralabs.istegelsin.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moralabs.istegelsin.R
import com.moralabs.istegelsin.databinding.ActivityMainBinding
import com.moralabs.istegelsin.databinding.ItemCategoryBinding
import com.moralabs.istegelsin.databinding.ItemSubCategoryBinding
import com.moralabs.istegelsin.domain.entity.Category

class CategoryAdapter(private val mList: List<Category>, val mainContext: Context, val mainBinding: ActivityMainBinding, val type: String):
    RecyclerView.Adapter<CategoryAdapterViewHolder>() {

    val list = mList
    var aPosition: Int = 0

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryAdapterViewHolder {

        when(p1) {
            R.layout.item_category -> {
                val binding = ItemCategoryBinding.inflate(LayoutInflater.from(p0.context), p0, false)
                return CategoryAdapterViewHolder.CategoryViewHolder(binding)
            }
            R.layout.item_sub_category -> {
                val binding = ItemSubCategoryBinding.inflate(LayoutInflater.from(p0.context), p0, false)
                return CategoryAdapterViewHolder.SubCategoryViewHolder(binding)
            }
        }

        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return CategoryAdapterViewHolder.CategoryViewHolder(binding)

    }

    override fun onBindViewHolder(p0: CategoryAdapterViewHolder, p1: Int) {
        when(p0){
            is CategoryAdapterViewHolder.CategoryViewHolder -> {
                p0.categoryItem.category = list[p1]
                p0.binding.setOnClickListener {
                    aPosition = p0.adapterPosition
                    var subCategoryList = list[aPosition].subcategories as List<Category>
                    mainBinding.subCategoriesRecycler.layoutManager = LinearLayoutManager(mainContext, LinearLayout.HORIZONTAL, false)
                    mainBinding.subCategoriesRecycler.adapter = CategoryAdapter(subCategoryList, mainContext, mainBinding, "subCategory")
                }
            }
            is CategoryAdapterViewHolder.SubCategoryViewHolder -> {
                p0.subCategoryItem.subCategory = list[p1]
            }
        }
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

}