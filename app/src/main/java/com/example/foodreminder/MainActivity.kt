package com.example.foodreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.foodreminder.ui.common.theme.FoodReminderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodReminderTheme {
                // todo: main screen goes here :)
            }
        }
    }
}