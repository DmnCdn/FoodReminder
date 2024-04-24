package com.example.foodreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodreminder.ui.common.navigation.NavigationItem
import com.example.foodreminder.ui.common.theme.FoodReminderTheme
import com.example.foodreminder.ui.products.edit.AddEditProductScreen
import com.example.foodreminder.ui.products.list.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodReminderTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = NavigationItem.ProductList.route
                ) {
                    composable(route = NavigationItem.ProductList.route) {
                        ProductListScreen(navController = navController)
                    }
                    composable(route = NavigationItem.AddEditProduct.route) {
                        AddEditProductScreen(navController = navController)
                    }
                }
            }
        }
    }
}