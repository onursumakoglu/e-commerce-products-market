package com.moralabs.istegelsin.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moralabs.istegelsin.databinding.ItemProductBinding
import com.moralabs.istegelsin.domain.entity.Product

class ProductAdapter(private val mList: List<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductsHolder>() {

    class ProductsHolder(val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductsHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return ProductsHolder(binding)
    }

    override fun onBindViewHolder(p0: ProductsHolder, p1: Int) {
        p0.binding.product = mList[p1]

    }

    override fun getItemCount(): Int {
        return mList.size
    }
}