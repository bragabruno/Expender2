package com.bragdev.expenderTwo.manager

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class ExpenseManager {
    // Declare a variable to store the total expenses
    var totalExpenses: Double = 0.0

    // Function to get the expense amount from the user

    @Composable
    fun getExpenseAmountFromUser(context: Context): Double {
        var expenseAmount = 0.0

        // Create a mutable state variable to store the expense amount
        val expenseAmountState = remember { mutableStateOf("") }

        return expenseAmount
    }

    fun updateTotalExpenses(expenseAmount: Double) {
        totalExpenses += expenseAmount
    }
}
