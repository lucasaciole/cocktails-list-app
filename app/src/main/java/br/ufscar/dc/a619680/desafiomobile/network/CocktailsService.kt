package br.ufscar.dc.a619680.desafiomobile.network

import retrofit2.http.GET

interface CocktailsService {

    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicCocktails()

}
