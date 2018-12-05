package br.ufscar.dc.a619680.desafiomobile.scenarios.main

import br.ufscar.dc.a619680.desafiomobile.entities.Cocktail
import br.ufscar.dc.a619680.desafiomobile.entities.CocktailList
import br.ufscar.dc.a619680.desafiomobile.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onActivityStart(){
        val cocktailsService = RetrofitInitializer().createCocktailsService()

        val call = cocktailsService.getAlcoholicCocktails()

        call.enqueue(object : Callback<CocktailList> {
            override fun onFailure(call: Call<CocktailList>, t: Throwable) {
                view.hideLoadingCircle()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<CocktailList>, response: Response<CocktailList>) {
                view.hideLoadingCircle()
                if(response.body() != null){
                    view.showDrinksList(response.body()!!.drinks)
                }else {
                    view.showMessage("Esse drink não está disponível")
                }
            }
        })


    }

    override fun onRandomButtonClicked() {
        val cocktailsService = RetrofitInitializer().createCocktailsService()
        val call = cocktailsService.getRandomDrink()
        call.enqueue(object : Callback<CocktailList> {
            override fun onFailure(call: Call<CocktailList>, t: Throwable) {
                view.showMessage("Problema ao contatar servidor! Verifique sua conexão.")
            }

            override fun onResponse(call: Call<CocktailList>, response: Response<CocktailList>) {
                if (response.body() != null) {
                    view.showDrinkDetails(response.body()!!.drinks.first())
                } else {
                    view.showMessage("Erro! Tente novamente.")
                }
            }
        })
    }

    override fun onCocktailClicked(cocktail: Cocktail) {
        val cocktailsService = RetrofitInitializer().createCocktailsService()

        val call = cocktailsService.getDrinkByID(cocktail.idDrink)
        call.enqueue(object : Callback<CocktailList> {
            override fun onFailure(call: Call<CocktailList>, t: Throwable) {
                view.showMessage("Erro na conexão.")
            }
            override fun onResponse(call: Call<CocktailList>, response: Response<CocktailList>) {
                if(response.body() != null) {
                    view.showDrinkDetails(response.body()!!.drinks.first())
                } else {
                    view.showMessage("Não foi possivel exibir esse coquetel.")
                }
            }
        })
    }

}