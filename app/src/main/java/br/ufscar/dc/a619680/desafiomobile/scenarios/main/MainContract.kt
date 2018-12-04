package br.ufscar.dc.a619680.desafiomobile.scenarios.main

interface MainContract {

    interface View {
        fun showMessage(msg: String)
        fun showDrinksList(cocktails: List<kotlin.Any>)
        fun showDrinkDetails()
        fun showLoadingCircle()
        fun hideLoadingCircle()
    }

    interface Presenter {
        fun onActivityStart()
        fun onRandomButtonClicked()
        fun onCocktailClicked()
    }
}