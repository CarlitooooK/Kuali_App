package com.example.kuali_app.screens

import androidx.annotation.ContentView
import androidx.compose.foundation.gestures.animateScrollBy
import com.example.kuali_app.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kuali_app.models.MainViewModel
import com.example.kuali_app.navigation.NavItem
import com.example.kuali_app.ui.theme.GilroyFont
import com.example.kuali_app.ui.theme.accent_color

@Composable
fun MainScreen(modifier: Modifier = Modifier,viewModel: MainViewModel = viewModel()) {

    val navItemList = listOf(
        NavItem("Home", painterResource(R.drawable.ic_home)),
        NavItem("Recipes", painterResource(R.drawable.ic_recipes)),
        NavItem("Statistics", painterResource(R.drawable.ic_statistics)),
        NavItem("My Chef", painterResource(R.drawable.ic_chef)),
    )

    val pagerState = rememberPagerState(
        initialPage = viewModel.selectedIndex,
    ) {
        navItemList.size
    }

    LaunchedEffect(pagerState.currentPage) {
        if(viewModel.selectedIndex != pagerState.currentPage){
            viewModel.updateIndex((pagerState.currentPage))
        }
    }

    LaunchedEffect(viewModel.selectedIndex) {
        pagerState.animateScrollToPage(viewModel.selectedIndex)
    }

    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    selected = viewModel.selectedIndex == 0,
                    onClick = { viewModel.updateIndex(0)  },
                    icon = {
                        Icon(navItemList[0].icon, "Icon", Modifier.size(24.dp))
                    },
                    label = {
                        Text(
                            navItemList[0].label,
                            fontFamily = GilroyFont,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = accent_color,
                        selectedTextColor = accent_color,
                        indicatorColor = Color.Transparent
                    )
                )
                NavigationBarItem(
                    selected = viewModel.selectedIndex == 1,
                    onClick = { viewModel.updateIndex(1) },
                    icon = {
                        Icon(navItemList[1].icon, "Icon", Modifier.size(24.dp))
                    },
                    label = {
                        Text(
                            navItemList[1].label,
                            fontFamily = GilroyFont,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = accent_color,
                        selectedTextColor = accent_color,
                        indicatorColor = Color.Transparent
                    )
                )
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(
                        onClick = {},
                        containerColor = accent_color,
                    ) {
                        Icon(
                            Icons.Default.AddCircle,
                            contentDescription = "Agregar",
                            tint = Color.White
                        )
                    }
                }
                NavigationBarItem(
                    selected = viewModel.selectedIndex == 2,
                    onClick = { viewModel.updateIndex(2) },
                    icon = {
                        Icon(navItemList[2].icon, "Icon", Modifier.size(24.dp))
                    },
                    label = {
                        Text(
                            navItemList[2].label,
                            fontFamily = GilroyFont,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = accent_color,
                        selectedTextColor = accent_color,
                        indicatorColor = Color.Transparent
                    )
                )
                NavigationBarItem(
                    selected = viewModel.selectedIndex == 3,
                    onClick = { viewModel.updateIndex(3) },
                    icon = {
                        Icon(navItemList[3].icon, "Icon", Modifier.size(24.dp))
                    },
                    label = {
                        Text(
                            navItemList[3].label,
                            fontFamily = GilroyFont,
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = accent_color,
                        selectedTextColor = accent_color,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        },
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            page ->
            ContentScreen(page = page)
        }
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, page:Int) {
    when (page) {
        0 -> HomeScreen()
        1 -> RecipesScreen()
        2 -> StatisticsScreen()
        3 -> ChefScreen()
    }

}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()

}