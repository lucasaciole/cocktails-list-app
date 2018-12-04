package br.ufscar.dc.a619680.desafiomobile.scenarios.main

interface MainContract {

    interface View {
        fun showMessage()
        fun showDrinksList(cocktails: List<Object>)
        fun showDrinkDetails()
        fun showLoadingCircle()
        fun hideLoadingCircle()
    }

    interface Presenter {
        fun onRandomButtonClicked()
        fun onCocktailClicked()
    }
}