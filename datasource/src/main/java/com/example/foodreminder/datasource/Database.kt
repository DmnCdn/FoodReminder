package com.example.foodreminder.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodreminder.model.Product

@Database(
    entities = [Product::class],
    version = 1
)
abstract class Database: RoomDatabase() {

    abstract val productsDao: ProductsDao
}