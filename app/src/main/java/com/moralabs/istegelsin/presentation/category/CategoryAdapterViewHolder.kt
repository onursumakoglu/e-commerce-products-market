package com.moralabs.istegelsin.presentation.category

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moralabs.istegelsin.databinding.ItemCategoryBinding
import com.moralabs.istegelsin.databinding.ItemSubCategoryBinding

sealed class CategoryAdapterViewHolder(val binding: View) : RecyclerView.ViewHolder(binding) {

    class CategoryViewHolder(var categoryItem: ItemCategoryBinding) : CategoryAdapterViewHolder(categoryItem.root)
    class SubCategoryViewHolder(var subCategoryItem: ItemSubCategoryBinding) : CategoryAdapterViewHolder(subCategoryItem.root)

}