package com.example.foodreminder.ui.common.navigation

sealed class NavigationItem(val route: String) {
    data object ProductList: NavigationItem(route = "product/list")
    data object AddEditProduct: NavigationItem(route = "product/add-edit")
}