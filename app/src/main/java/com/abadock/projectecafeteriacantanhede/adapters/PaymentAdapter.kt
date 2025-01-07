package com.abadock.projectecafeteriacantanhede.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abadock.projectecafeteriacantanhede.R
import com.abadock.projectecafeteriacantanhede.ViewModel.CartViewModel
import com.abadock.projectecafeteriacantanhede.data.FoodModel

class PaymentAdapter(private val mList: List<FoodModel>, private val cartviewmodel: CartViewModel) : RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.payment_recycler, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val FoodModel = mList[position]

        holder.plateImage.setImageResource(R.drawable.croissant_png)
        holder.plateName.text = FoodModel.name
        holder.allergies.text = FoodModel.allergies
        holder.price.text = FoodModel.price.toString()

        holder.layoutRecycler.setOnClickListener{
            cartviewmodel.deleteFood(position)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val plateImage: ImageView = itemView.findViewById(R.id.imageProdPagament)
        val plateName: TextView = itemView.findViewById(R.id.nomProductePagament)
        val allergies: TextView = itemView.findViewById(R.id.alergiesProdPagament)
        val price: TextView = itemView.findViewById(R.id.preuProdPagament)
        val layoutRecycler: LinearLayout = itemView.findViewById(R.id.LayoutPagament)
    }
}