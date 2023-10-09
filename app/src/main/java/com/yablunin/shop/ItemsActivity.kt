package com.yablunin.shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yablunin.shop.adapters.ItemsAdapter

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.items_list);
        val items = arrayListOf<Item>();

        items.add(Item(0, "sofa", "Sofa", "Simple leather sofa", "A regular leather sofa that will fit perfectly into the interior of your living room. The elegant look will add more modernity to your interior.", 250));
        items.add(Item(1, "chair", "Chair", "Simple leather chair", "A regular leather chair that will fit perfectly into the interior of your living room. The elegant look will add more modernity to your interior.", 80));
        items.add(Item(2, "lamp", "Lamp", "Simple Lamp", "A lamp is an electrical device that provides artificial light by using an electric bulb. It typically consists of a base, a lampshade or light fixture, and a bulb. Lamps come in various styles, sizes, and designs to suit different purposes and aesthetics.", 100));

        itemsList.layoutManager = LinearLayoutManager(this);
        itemsList.adapter = ItemsAdapter(items, this);
    }
}