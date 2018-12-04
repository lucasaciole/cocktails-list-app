package br.ufscar.dc.a619680.desafiomobile.scenarios.main

import br.ufscar.dc.a619680.desafiomobile.entities.Cocktail

interface MainContract {

    interface View {
        fun showMessage(msg: String)
        fun showDrinksList(cocktails: List<Cocktail>)
        fun showDrinkDetails()
        fun showLoadingCircle()
        fun hideLoadingCircle()
    }

    interface Presenter {
        fun onActivityStart()
        fun onRandomButtonClicked()
        fun onCocktailClicked(cocktails: Cocktail)
    }
}