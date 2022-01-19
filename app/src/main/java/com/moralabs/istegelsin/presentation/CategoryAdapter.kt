package com.moralabs.istegelsin.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moralabs.istegelsin.data.remote.dto.CategoryDTO
import com.moralabs.istegelsin.data.remote.dto.CategoryResponse
import com.moralabs.istegelsin.databinding.ItemCategoryBinding
import com.moralabs.istegelsin.domain.entity.Category
import java.util.*

class CategoryAdapter(private val mList: MutableList<Category>):
    RecyclerView.Adapter<CategoryAdapter.CategoriesHolder>() {

    val list = mList

    inner class CategoriesHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryAdapter.CategoriesHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(p0.context), p0, false)

        return CategoriesHolder(binding)
    }

    override fun onBindViewHolder(p0: CategoryAdapter.CategoriesHolder, p1: Int) {



        val newList = list.get(p1).name

        println("aaa" + newList)

        p0.binding.categoryText.text = list.get(p1).name

        //p0.binding.categoryText.text = list?.get(p1)!!.name


        /*
        println(list!!.size)
        println(list!!)
        println(categoryList.size)

        println(list?.get(p1)!!.name)

        p0.binding.categoryText.text = list?.get(p1)!!.name

         */


    }

    override fun getItemCount(): Int {
        return list.size
    }

}