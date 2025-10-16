package com.example.kuali_app.screens

import androidx.annotation.ContentView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kuali_app.navigation.NavItem

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navItemList = listOf(
        NavItem("Home", Icons.Filled.Home),
        NavItem("Add Product", Icons.Filled.AddCircle),
        NavItem("Recipes", Icons.Filled.ThumbUp),
        NavItem("Statistics", Icons.Default.ShoppingCart),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(navItem.icon,"Icon")
                        },
                        label = {
                            Text(navItem.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(Modifier.padding(innerPadding),selectedIndex)
        }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex:Int) {
    when(selectedIndex){
        0 -> HomeScreen()
        1 -> AddScreen()
        2 -> RecipesScreen()
        3 -> StatisticsScreen()
    }

}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
    
}