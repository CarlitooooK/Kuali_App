package com.example.kuali_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.kuali_app.components.ProductCard
import com.example.kuali_app.ui.theme.GilroyFont
import com.example.kuali_app.viewmodel.ProductViewModel

@Composable
fun ProductsScreen(viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.products.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize().background(Color.White)
        .padding(16.dp)) {
        Text(
            "Find your products",
            fontWeight = FontWeight.Bold,
            fontFamily = GilroyFont,
            fontSize = 22.sp,
            modifier = Modifier.padding(top = 50.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(products) { product ->
                Card(
                    Modifier
                        .width(70.dp)
                        .height(210.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        AsyncImage(
                            model = product.image_front_url,
                            contentDescription = product.product_name,
                            modifier = Modifier
                                .size(130.dp)
                                .padding(top = 10.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(Modifier.weight(1f))
                        Text(
                            product.product_name ?: "Unnamed",
                            fontFamily = GilroyFont,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductsScreenPreview() {
    ProductsScreen()
}