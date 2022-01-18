package com.moralabs.istegelsin.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("data") var products: List<ProductDTO>? = null

)