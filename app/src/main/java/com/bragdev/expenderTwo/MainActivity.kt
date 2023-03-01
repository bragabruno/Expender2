package com.bragdev.expenderTwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bragdev.expenderTwo.api.AccountsResource
import com.bragdev.expenderTwo.api.PlaidService
import com.bragdev.expenderTwo.data.BudgetData
import com.bragdev.expenderTwo.ui.theme.Expender_2Theme
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://development.plaid.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    val plaidService = retrofit.create(PlaidService::class.java)
    val accountsResource = AccountsResource(plaidService)


    @ExperimentalMaterial3Api
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Expender_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BudgetAppScreen()
                }
            }
        }
    }
}

// @Composable
// fun Greeting(name: String) {
//    Text(text = "Hello $name!")
// }
//
// @Preview(showBackground = true)
// @Composable
// fun DefaultPreview() {
//    Expender_2Theme {
//        Greeting("Android")
//    }
// }

@Preview
@Composable
fun BudgetAppScreen(budgetData: BudgetData = BudgetData()) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Total Expenses: ${budgetData.totalExpenses}")
        Button(
            onClick = {

            },
            Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(actionText)
        }

        Text("Total Income: ${budgetData.totalIncome}")

        Text("Total Balance: ${budgetData.totalBalance}")

//        MyButton {
// //
//        }

        // Add a button to add income
//        Button(onClick = {
//            // Add code here to update the total income
//        }) {
//            expenseManager.updateTotalIncome(incomeAmount)
//            Text("Add Income")
//        }
//
//        // Add a button to reset the totals
//        Button(onClick = {
//        }) {
//            expenseManager.resetTotals()
//            Text("Reset Totals")
//        }
    }
}

@Preview
@Composable
fun onButtonClick() {
    AlertDialog(
        onDismissRequest = { },
        title = { Text("Enter the expense amount") },
        text = {
            Text("Enter Amount")
        },
        confirmButton = {
            TextButton(onClick = { }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = { }) {
                Text("Cancel")
            }
        }
    )
}
//
// @Composable
// fun MyButton(onButtonClick: () -> Unit) {
//    Button(
//        onClick = {
//            onButtonClick()
//        },
//        Modifier
//            .padding(top = 16.dp)
//            .align(Alignment.CenterHorizontally)
//    ) {
//        Text("Add Expense")
//    }
// }
