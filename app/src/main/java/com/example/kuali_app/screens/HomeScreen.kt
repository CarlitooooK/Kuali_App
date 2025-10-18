package com.example.kuali_app.screens

import androidx.compose.foundation.Image
import com.example.kuali_app.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kuali_app.components.ProductCard
import com.example.kuali_app.ui.theme.GilroyFont

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Home()
}

@Composable
fun Home(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(Modifier.height(30.dp))
        HeaderWidget()
        Subtitles("My Cupboard")
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) {
                ProductCard()
            }
        }

        Subtitles("Expiring Soon")
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5){
                ProductCard()
            }
        }

        Subtitles("My Recipes")

    }

}

@Composable
fun HeaderWidget(modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painterResource(R.drawable.logo),
            contentDescription = null,
            Modifier
                .size(70.dp)
                .padding(bottom = 10.dp)
        )
        Text(
            "Kuali",
            modifier = Modifier.padding(bottom = 10.dp),
            fontFamily = GilroyFont,
            fontWeight = FontWeight.Medium,
            fontSize = 30.sp,
        )
    }

}

@Composable
fun Subtitles(text: String) {
    Spacer(Modifier.height(20.dp))
    Text(text, fontFamily = GilroyFont, fontWeight = FontWeight.Bold, fontSize = 22.sp)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    Home()
}