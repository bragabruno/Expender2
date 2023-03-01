package com.bragdev.expenderTwo.api

import com.bragdev.expenderTwo.data.AccountsGetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaidService {
    @GET("/accounts")
    fun getAccounts(@Query("access_token") accessToken: String): Call<AccountsGetResponse>
}
