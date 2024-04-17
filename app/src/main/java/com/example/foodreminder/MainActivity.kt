package com.example.foodreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.foodreminder.ui.common.theme.FoodReminderTheme
import com.example.foodreminder.ui.products.list.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodReminderTheme {
                ProductListScreen()
            }
        }
    }
}