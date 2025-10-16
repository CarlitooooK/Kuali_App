package com.example.kuali_app.components

import android.text.Layout
import android.widget.Space
import com.example.kuali_app.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kuali_app.ui.theme.GilroyFont

@Composable
fun ProductCard(modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(
            Modifier
                .width(150.dp)
                .height(220.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_chef),
                    contentDescription = "Product",
                    Modifier
                        .size(100.dp)
                        .padding(top = 10.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(Modifier.weight(1f))
                Column(Modifier.fillMaxWidth()) {
                    Text("Product Name", fontFamily = GilroyFont, fontWeight = FontWeight.Medium)
                    Text("Expiration Day", fontFamily = GilroyFont, fontWeight = FontWeight.Light)
                }
                Spacer(Modifier.weight(1f))
                Text("8 pieces", fontFamily = GilroyFont, fontWeight = FontWeight.SemiBold)
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CardPreview() {
    ProductCard()
}