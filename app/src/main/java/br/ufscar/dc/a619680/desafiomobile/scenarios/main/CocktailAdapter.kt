package br.ufscar.dc.a619680.desafiomobile.scenarios.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.ufscar.dc.a619680.desafiomobile.R
import br.ufscar.dc.a619680.desafiomobile.entities.Cocktail
import br.ufscar.dc.a619680.desafiomobile.utils.GlideApp
import kotlinx.android.synthetic.main.cocktail_list_item.view.*

class CocktailAdapter (val context: Context, val cocktails: List<Cocktail>) : RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, vieType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cocktail_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cocktails.size
    }

    override fun onBindViewHolder(holder: CocktailAdapter.ViewHolder, position: Int) {
        holder.bindView(context, cocktails[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(context: Context, cocktail: Cocktail, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.cocktailName.text = cocktail.strDrink

            GlideApp.with(context)
                    .load(cocktail.strDrinkThumb)
                    .placeholder(R.drawable.cocktail_placeholder)
                    .centerCrop()
                    .into(itemView.cocktailImage)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

        }
    }
}