package br.ufscar.dc.a619680.desafiomobile.scenarios.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import br.ufscar.dc.a619680.desafiomobile.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  AppCompatActivity(), MainContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onActivityStart()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showDrinksList(cocktails: List<kotlin.Any>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDrinkDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingCircle() {
        loading_circle.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoadingCircle() {
        loading_circle.visibility = ProgressBar.INVISIBLE
    }
}
