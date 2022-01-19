package com.moralabs.istegelsin.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("data") var categories: List<CategoryDTO>? = null

)