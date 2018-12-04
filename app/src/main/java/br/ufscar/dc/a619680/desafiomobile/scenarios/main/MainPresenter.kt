package br.ufscar.dc.a619680.desafiomobile.scenarios.main

import br.ufscar.dc.a619680.desafiomobile.entities.Cocktail
import br.ufscar.dc.a619680.desafiomobile.entities.CocktailList
import br.ufscar.dc.a619680.desafiomobile.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onActivityStart(){
        view.showLoadingCircle()

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
                    view.showMessage("Tudo certo!")
                }else {
                    view.showMessage("Esse drink não está disponível")
                }
            }
        })

        view.hideLoadingCircle()
    }

    override fun onRandomButtonClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCocktailClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}