package com.example.laundryapp.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laundryapp.*
import com.example.laundryapp.api.menu.MenuViewModel
import com.example.laundryapp.api.price.PriceViewModel
import com.example.laundryapp.api.store.StoreViewModel
import com.example.laundryapp.components.ButtonView
import com.example.laundryapp.components.views.ViewHome
//import com.example.laundryapp.components.home.HomeLoadData
import com.example.laundryapp.components.views.ViewTopBarHome
import com.example.laundryapp.navigation.Screens
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScreenHome(
    navController: NavController,
    storeViewModel: StoreViewModel,
    menuViewModel: MenuViewModel,
    priceViewModel: PriceViewModel
) {
    val context = LocalContext.current

    val current = LocalDateTime.now()

    val formatDay = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val date = current.format(formatDay)
    DATE_PICK = date

    Scaffold(
        topBar = { ViewTopBarHome(
            navController = navController,
            title = STORE_NAME
        ) }
    ){
        WallHome(
            storeViewModel = storeViewModel,
            navController = navController,
            menuViewModel = menuViewModel,
            priceViewModel = priceViewModel
        )
    }

}

@Composable
fun WallHome(
    navController: NavController,
    storeViewModel: StoreViewModel,
    menuViewModel: MenuViewModel,
    priceViewModel: PriceViewModel
) {
    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        ViewHome(menuViewModel = menuViewModel, priceViewModel = priceViewModel, navController = navController)
    }
}