package com.example.laundryapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.laundryapp.api.customer.CustomerViewModel
import com.example.laundryapp.api.price.PriceViewModel
import com.example.laundryapp.components.views.screens.ViewCustomer
import com.example.laundryapp.components.views.screens.ViewMenuNew

@Composable
fun ScreenCustomer(
    customerViewModel: CustomerViewModel,
    navController: NavController,
) {
    WallCustomer(
       customerViewModel = customerViewModel,
        navController = navController)
}

@Composable
fun WallCustomer(
    customerViewModel: CustomerViewModel,
    navController: NavController
) {
    Box {
        ViewCustomer(
            customerViewModel = customerViewModel,
            navController = navController)
    }
}