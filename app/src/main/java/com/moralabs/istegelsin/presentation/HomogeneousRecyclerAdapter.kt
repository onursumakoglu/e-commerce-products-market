package com.moralabs.istegelsin.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class HomogeneousRecyclerAdapter<Binding: ViewDataBinding, Model> (
    private val items: List<Model>,
    private val layoutId: Int,
    private val modelId: Int,
    private val onClick: (Model) -> Unit = {}
): RecyclerView.Adapter<HomogeneousRecyclerAdapter.ViewHolder<Binding>>() {

    class ViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = ViewHolder<Binding> (
        DataBindingUtil.inflate(LayoutInflater.from(p0.context), layoutId, p0, false)
    )

    override fun onBindViewHolder(p0: ViewHolder<Binding>, p1: Int) {
        p0.binding.setVariable(modelId, items[p1])
        p0.binding.executePendingBindings()
        p0.itemView.setOnClickListener { onClick(items[p1%items.size]) }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

/*
fun <Binding : ViewDataBinding, Model> RecyclerView.bind(
    owner: FragmentActivity,
    data: Observable<List<Model>>,
    layoutId: Int,
    modelId: Int,
    isInfinite: Boolean,
    layoutManager: RecyclerView.LayoutManager,
    onClick: (Model) -> Unit = {}
) {
    this.layoutManager = layoutManager

    data.observe(owner) {
        this.adapter = HomogeneousRecyclerAdapter<Binding, Model>(it, layoutId, modelId, onClick,isInfinite)
    }
}

 */