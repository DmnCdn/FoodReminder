package com.example.foodreminder.ui.products.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodreminder.domain.usecase.GetProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject internal constructor(
    getProductListUseCase: GetProductListUseCase,
): ViewModel() {

    init {
        getProductListUseCase().onEach {
            Log.d("ProductListViewModel", "product list: $it")
        }.launchIn(viewModelScope)
    }
}