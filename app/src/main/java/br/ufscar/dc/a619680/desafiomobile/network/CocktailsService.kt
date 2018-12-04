package br.ufscar.dc.a619680.desafiomobile.network

import br.ufscar.dc.a619680.desafiomobile.entities.Cocktail
import br.ufscar.dc.a619680.desafiomobile.entities.CocktailList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsService {

    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicCocktails(): Call<CocktailList>

    @GET("random.php")
    fun getRandomDrink(): Call<CocktailList>

    @GET("https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=")
    fun getDrinkByID(@Query("i")query: String): Call<CocktailList>

}
