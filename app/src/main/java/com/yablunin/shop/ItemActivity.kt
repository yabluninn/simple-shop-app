package com.yablunin.shop

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val itemTitle: TextView = findViewById(R.id.item_title_text);
        val itemLongDescr: TextView = findViewById(R.id.item_long_descr_text);
        val itemPrice: TextView = findViewById(R.id.item_price_text);
        val buyButton: Button = findViewById(R.id.item_buy_button);

        itemTitle.text = intent.getStringExtra("itemTitle");
        itemLongDescr.text = intent.getStringExtra("itemLongDescr");
        itemPrice.text = "Price: ${intent.getStringExtra("itemPrice")} $";

        buyButton.setOnClickListener {
            val intent = Intent(this, ItemsActivity::class.java);
            startActivity(intent);
        }


    }
}