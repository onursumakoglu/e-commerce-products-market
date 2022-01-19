package com.moralabs.istegelsin.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.moralabs.istegelsin.domain.entity.Category

data class CategoryDTO (
    @SerializedName("id") var id: String? = null,
    @SerializedName("parentCategoryID") var parentCategoryID: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("subcategories") var subcategories: List<Category>? = null
)