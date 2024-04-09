package com.example.foodreminder.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.foodreminder.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Upsert
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM product")
    fun observeProducts(): Flow<List<Product>>
}