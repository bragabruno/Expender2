package com.bragdev.expenderTwo.api

import com.bragdev.expenderTwo.data.AccountsGetResponse
import dagger.producers.Produces
import retrofit2.http.GET

class AccountsResource(val plaidService: PlaidService) {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAccounts(): AccountsGetResponse? {
        val call = plaidService.getAccounts(QuickstartApplication.accessToken)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}
