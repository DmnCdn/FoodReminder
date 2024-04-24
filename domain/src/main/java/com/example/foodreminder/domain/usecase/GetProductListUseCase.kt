package com.example.foodreminder.domain.usecase

import com.example.foodreminder.domain.dispatchers.DispatchersIO
import com.example.foodreminder.domain.model.ProductUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetProductListUseCase @Inject internal constructor(
    @DispatchersIO private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<List<ProductUI>> = flow {
        emit(getMockProductList())
    }.flowOn(coroutineDispatcher)

    private fun getMockProductList(): List<ProductUI> = listOf(
        ProductUI(
            id = 1,
            name = "Bananas",
            amount = 10
        ),
        ProductUI(
            id = 2,
            name = "Chicken",
            amount = 2,
        ),
        ProductUI(
            id = 3,
            name = "Buns",
            amount = 10,
        ),
        ProductUI(
            id = 4,
            name = "Water bottle",
            amount = 3,
        ),
    )
}