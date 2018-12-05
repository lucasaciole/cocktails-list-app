package br.ufscar.dc.a619680.desafiomobile.scenarios.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.ufscar.dc.a619680.desafiomobile.R
import br.ufscar.dc.a619680.desafiomobile.entities.Cocktail
import br.ufscar.dc.a619680.desafiomobile.utils.GlideApp
import kotlinx.android.synthetic.main.cocktail_details.*
import kotlinx.android.synthetic.main.cocktail_list_item.*

class CocktailDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cocktail_details)

        if (intent.extras != null) {
            val myData : Cocktail = intent.getSerializableExtra("cocktailDetailView") as Cocktail
            detailsCocktailName.text = myData.strDrink
            GlideApp.with(this)
                    .load(myData.strDrinkThumb)
                    .placeholder(R.drawable.cocktail_placeholder)
                    .centerCrop()
                    .into(detailsCocktailImage)

            val ingredients = mutableListOf(myData.strIngredient1, myData.strIngredient2,
                    myData.strIngredient3, myData.strIngredient4, myData.strIngredient5,
                    myData.strIngredient6, myData.strIngredient7, myData.strIngredient8,
                    myData.strIngredient9, myData.strIngredient10, myData.strIngredient11,
                    myData.strIngredient12, myData.strIngredient13, myData.strIngredient14,
                    myData.strIngredient15)
            val quantities = mutableListOf(myData.strMeasure1, myData.strMeasure2,
                    myData.strMeasure3, myData.strMeasure4, myData.strMeasure5, myData.strMeasure6,
                    myData.strMeasure7, myData.strMeasure8, myData.strMeasure9, myData.strMeasure10,
                    myData.strMeasure11, myData.strMeasure12, myData.strMeasure13,
                    myData.strMeasure14, myData.strMeasure15)

            val ingredientsIterator = ingredients.listIterator()
            val quantityIterator = quantities.listIterator()
            val stringIngredient = java.lang.StringBuilder()
            val stringQuantity = StringBuilder()
            val stringGlass = StringBuilder()
            stringGlass.append("Serve with: ").append(myData.strGlass)
            for(item in ingredientsIterator){
                if(!item.isNullOrBlank()){
                    stringIngredient.append(item).append('\n').append('\n')
                }
            }
            for(item in quantityIterator){
                if(!item.isNullOrBlank()){
                    stringQuantity.append(item).append('\n').append('\n')
                }
            }

            ingredientList.text = stringIngredient
            quantityList.text = stringQuantity
            isAlcoholicLabel.text = myData.strAlcoholic
            glassType.text = stringGlass
            instructions.text = myData.strInstructions
        }
    }
}