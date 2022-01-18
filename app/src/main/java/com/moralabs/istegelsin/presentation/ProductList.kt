package com.moralabs.istegelsin.presentation

import com.moralabs.istegelsin.domain.entity.Product

data class ProductList (
    var list: MutableList<Product>?
)