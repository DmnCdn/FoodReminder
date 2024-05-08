package com.example.foodreminder.ui.products.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodreminder.domain.usecase.GetProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class ProductListViewModel @Inject constructor(
    getProductListUseCase: GetProductListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ProductListViewState())
    val state: StateFlow<ProductListViewState> = _state.asStateFlow()

    init {
        getProductListUseCase().onEach { productList ->
            _state.update { it.copy(products = productList) }
        }.launchIn(viewModelScope)
    }
}