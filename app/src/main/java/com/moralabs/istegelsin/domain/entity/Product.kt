package com.moralabs.istegelsin.domain.entity

data class Product (
    var id: String? = null,
    var name: String? = null,
    var imageUrl: String? = null,
    var price: Double? = null,
    var promotionDiscountPercentage: Double? = null
) : Entity()