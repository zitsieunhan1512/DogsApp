package com.example.listviewadvancedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.line_food.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arrayfood: ArrayList<Food> = ArrayList()
        arrayfood.add(Food("bread", R.drawable.food))
        arrayfood.add(Food("chagio", R.drawable.dog))
        arrayfood.add(Food("com", R.drawable.dog2))
        arrayfood.add(Food("canh", R.drawable.sz))
        arrayfood.add(Food("suon", R.drawable.z))
        listview.adapter = CustomAdapter(this@MainActivity, arrayfood)

    }
}