package br.ufscar.dc.a619680.desafiomobile.scenarios.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.ufscar.dc.a619680.desafiomobile.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  AppCompatActivity(), MainContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMessage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDrinksList(cocktails: List<Object>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDrinkDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingCircle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingCircle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
