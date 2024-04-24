package com.example.foodreminder.ui.products.list

sealed interface ProductListViewAction {
    data class OnProductClicked(val productId: Int): ProductListViewAction
    data object OnNewProduct: ProductListViewAction
}