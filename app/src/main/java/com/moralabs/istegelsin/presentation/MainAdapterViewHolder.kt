package com.moralabs.istegelsin.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moralabs.istegelsin.databinding.ItemCategoryBinding

sealed class MainAdapterViewHolder(val binding: View) : RecyclerView.ViewHolder(binding) {

    class CategoryViewHolder(var categoryItem: ItemCategoryBinding) : MainAdapterViewHolder(categoryItem.root)
}