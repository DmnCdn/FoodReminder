package com.example.foodreminder.ui.products.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.foodreminder.ui.common.navigation.NavigationItem
import com.example.foodreminder.ui.common.theme.FoodReminderTheme
import com.example.foodreminder.ui.products.list.components.ProductItem

@Composable
fun ProductListScreen(navController: NavController) {
    val viewModel: ProductListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val onViewAction: (ProductListViewAction) -> Unit = remember(navController) {
        { action ->
            when (action) {
                ProductListViewAction.OnNewProduct -> navController.navigate(route = NavigationItem.AddEditProduct.route)
                is ProductListViewAction.OnProductClicked -> navController.navigate(route = NavigationItem.AddEditProduct.route)
            }
        }
    }

    ProductListScreenContent(onViewAction = onViewAction, viewState = state)
}

@Composable
internal fun ProductListScreenContent(
    onViewAction: (ProductListViewAction) -> Unit,
    viewState: ProductListViewState
) {
    var isScrollingDown by remember { mutableStateOf(false) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                when {
                    isScrollingDown && delta > 0 -> isScrollingDown = false
                    !isScrollingDown && delta < 0 -> isScrollingDown = true
                }
                return Offset.Zero
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(
                visible = !isScrollingDown,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                FloatingActionButton(
                    onClick = { onViewAction(ProductListViewAction.OnNewProduct) },
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.nestedScroll(nestedScrollConnection),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                itemsIndexed(
                    items = viewState.products,
                    key = { _, product -> product.id }
                ) { index, product ->
                    ProductItem(
                        name = product.name,
                        quantity = product.amount,
                        showBottomDivider = index < viewState.products.lastIndex,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onViewAction(ProductListViewAction.OnProductClicked(product.id))
                            }
                            .padding(top = 16.dp)
                            .padding(horizontal = 16.dp),
                        backgroundColor = Color.Transparent,
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewProductListScreen() {
    FoodReminderTheme {
        ProductListScreenContent(
            onViewAction = {},
            viewState = ProductListViewState()
        )
    }
}