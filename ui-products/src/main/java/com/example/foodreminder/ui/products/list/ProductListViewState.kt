package com.example.foodreminder.ui.products.list

import com.example.foodreminder.domain.model.ProductUI

internal data class ProductListViewState(
    val products: List<ProductUI> = emptyList(),
)