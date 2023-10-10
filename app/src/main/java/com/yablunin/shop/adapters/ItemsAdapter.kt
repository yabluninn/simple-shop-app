package com.yablunin.shop.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yablunin.shop.Item
import com.yablunin.shop.ItemActivity
import com.yablunin.shop.R

class ItemsAdapter (val items: List<Item>, val context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>(){

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_image);
        val title: TextView = view.findViewById(R.id.item_title);
        val shortDescr: TextView = view.findViewById(R.id.item_short_descr);
        val longDescr: TextView = view.findViewById(R.id.item_long_descr);
        val price: TextView = view.findViewById(R.id.item_price);

        val button: Button = view.findViewById(R.id.item_more_button);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_element, parent, false);
        return MyViewHolder(view);
    }

    override fun getItemCount(): Int {
        return items.count();
    }

    @SuppressLint("SetTextI18n", "DiscouragedApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title;
        holder.shortDescr.text = items[position].shortDescr;
        holder.longDescr.text = items[position].longDescr;
        holder.price.text = "Price: ${items[position].price} $";

        val imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId);

        holder.button.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java);

            intent.putExtra("itemTitle", items[position].title);
            intent.putExtra("itemLongDescr", items[position].longDescr);
            intent.putExtra("itemPrice", items[position].price);

            context.startActivity(intent);
        }
    }
}