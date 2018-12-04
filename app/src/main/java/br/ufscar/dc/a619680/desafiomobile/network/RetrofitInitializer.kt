package br.ufscar.dc.a619680.desafiomobile.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    val retrofit = Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    fun createCocktailsService() = retrofit.create(CocktailsService::class.java)

}