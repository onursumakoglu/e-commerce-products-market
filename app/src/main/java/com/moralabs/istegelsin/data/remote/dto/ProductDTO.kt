package com.moralabs.istegelsin.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductDTO (
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("imageUrl") var imageUrl: String? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("promotionDiscountPercentage") var promotionDiscountPercentage: Double? = null
)