package com.moralabs.istegelsin.data.remote.api

import com.google.gson.annotations.SerializedName

data class DetailsRequest (
        @SerializedName("subCategoryID") val subCategoryID: String? = null,
        @SerializedName("keyword") val keyword: String? = null
)