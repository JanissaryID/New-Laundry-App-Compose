package com.example.laundryapp.navigation

import android.os.Build
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.laundryapp.DATE_PICK
import com.example.laundryapp.KEY_URL
import com.example.laundryapp.STORE_ID
import com.example.laundryapp.STORE_NAME
import com.example.laundryapp.api.machine.MachineViewModel
import com.example.laundryapp.api.menu.MenuViewModel
import com.example.laundryapp.api.payment.PaymentViewModel
import com.example.laundryapp.api.price.PriceViewModel
import com.example.laundryapp.api.qris.QrisViewModel
import com.example.laundryapp.api.store.StoreViewModel
import com.example.laundryapp.api.transaction.TransactionViewModel
import com.example.laundryapp.proto.ProtoViewModel
import com.example.laundryapp.screens.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraphSetup(
    navController: NavHostController,
    storeViewModel: StoreViewModel,
    qrisViewModel: QrisViewModel,
    menuViewModel: MenuViewModel,
    priceViewModel: PriceViewModel,
    machineViewModel: MachineViewModel,
    transactionViewModel: TransactionViewModel,
    paymentViewModel: PaymentViewModel,
    protoViewModel: ProtoViewModel,
//    excelViewModel: ExcelViewModel,
    componentActivity: ComponentActivity
) {
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = Screens.Home.route){

        composable(
            route = Screens.Home.route,
        ){
            menuViewModel.getMenu()
            ScreenHome(
                storeViewModel = storeViewModel,
                navController = navController,
                menuViewModel = menuViewModel,
                priceViewModel = priceViewModel
            )
        }

        composable(
            route = Screens.Qris.route,
        ){
            LaunchedEffect(key1 = STORE_ID){
                Log.d("debug", "Qris NavGraph")
                paymentViewModel.getQR()
            }
            ScreenQris(
                navController = navController,
                paymentViewModel = paymentViewModel
            )
        }
        
        composable(
            route = Screens.TransactionActive.route,
        ){
            LaunchedEffect(key1 = STORE_ID){
                Log.d("debug", "Date : ${DATE_PICK}")
                if (DATE_PICK != ""){
                    transactionViewModel.getTransaction(isFinish = false)
                }
            }
            ScreenTransactionActive(navController = navController, transactionViewModel = transactionViewModel)
        }

        composable(
            route = Screens.TransactionFinish.route,
        ){
            LaunchedEffect(key1 = STORE_ID){
                Log.d("debug", "Date : ${DATE_PICK}")
                if (DATE_PICK != ""){
                    transactionViewModel.getTransaction(isFinish = true)
                }
            }
            ScreenTransactionFinish(navController = navController, transactionViewModel = transactionViewModel)
        }

        composable(
            route = Screens.Machine.route,
        ){
            LaunchedEffect(key1 = STORE_ID){
                machineViewModel.getMachine()
//                Log.d("debug", "Store ID : ${STORE_ID}")
            }
            ScreenMachine(
                navController = navController,
                machineViewModel = machineViewModel,
                transactionViewModel = transactionViewModel
            )
        }

        composable(
            route = Screens.Setting.route,
        ){
            ScreenSetting(
                protoViewModel = protoViewModel,
                navController = navController,
            )
        }

    }
}