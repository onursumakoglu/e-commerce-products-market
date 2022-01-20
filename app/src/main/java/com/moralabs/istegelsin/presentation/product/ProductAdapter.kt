package com.moralabs.istegelsin.presentation.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moralabs.istegelsin.R
import com.moralabs.istegelsin.databinding.ItemProductBinding
import com.moralabs.istegelsin.domain.entity.Product

class ProductAdapter(private val mList: List<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductsHolder>() {

    var aPosition: Int = 0

    class ProductsHolder(val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductsHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return ProductsHolder(binding)
    }

    override fun onBindViewHolder(p0: ProductsHolder, p1: Int) {

        p0.binding.product = mList[p1]

        if (mList[p1].promotionDiscountPercentage!!.equals(0.0))
            p0.binding.productOldPrice.visibility = View.GONE

        p0.binding.addIconCard.setOnClickListener {
            aPosition = p0.adapterPosition
            mList[aPosition].basket = mList[aPosition].basket!! + 1
            p0.binding.addIconCard.visibility = View.GONE
            p0.binding.addDecreaseCard.visibility = View.VISIBLE
            p0.binding.productCountText.text = mList[aPosition].basket.toString()

            basketControl(p0, aPosition)
        }

        p0.binding.increaseIconCard.setOnClickListener {
            aPosition = p0.adapterPosition
            mList[aPosition].basket = mList[aPosition].basket!! + 1
            p0.binding.productCountText.text = mList[aPosition].basket.toString()

            basketControl(p0, aPosition)
        }

        p0.binding.decreaseDeleteIcon.setOnClickListener {
            aPosition = p0.adapterPosition
            mList[aPosition].basket = mList[aPosition].basket!! - 1
            p0.binding.productCountText.text = mList[aPosition].basket.toString()

            basketControl(p0, aPosition)

            if(mList[aPosition].basket!!.equals(0)){
                p0.binding.addIconCard.visibility = View.VISIBLE
                p0.binding.addDecreaseCard.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun basketControl(p0: ProductsHolder, aPosition: Int) {
        if (mList[aPosition].basket!!.equals(1))
            p0.binding.decreaseDeleteIcon.setImageResource(R.drawable.ic_delete)
        else
            p0.binding.decreaseDeleteIcon.setImageResource(R.drawable.ic_decrease)
    }
}