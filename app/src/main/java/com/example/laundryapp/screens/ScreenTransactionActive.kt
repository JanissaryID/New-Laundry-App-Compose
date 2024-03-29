package com.example.laundryapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laundryapp.TITLE_SCREEN
import com.example.laundryapp.api.machine.MachineViewModel
import com.example.laundryapp.api.payment.PaymentViewModel
import com.example.laundryapp.api.transaction.TransactionViewModel
import com.example.laundryapp.components.views.ViewTopBar
import com.example.laundryapp.components.views.screens.ViewMachine
import com.example.laundryapp.components.views.screens.ViewTransactionActive
import com.example.laundryapp.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTransactionActive(
    navController: NavController,
    transactionViewModel: TransactionViewModel
) {
    val context = LocalContext.current

    Scaffold(
        topBar = { ViewTopBar(
            navController = navController,
            title = TITLE_SCREEN[1],
            screenBack = Screens.Home.route
        ) }
    ){
        WallTransactionActive(
            transactionViewModel = transactionViewModel,
            navController = navController
        )
    }

}

@Composable
fun WallTransactionActive(
    transactionViewModel: TransactionViewModel,
    navController: NavController,
) {
    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        ViewTransactionActive(
            navController = navController,
            transactionViewModel = transactionViewModel
        )
    }
}