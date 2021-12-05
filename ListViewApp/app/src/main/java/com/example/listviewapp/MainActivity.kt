package com.example.listviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arraySubject: List<String> = listOf("IOS", "Android", "OS", "Math")
        listview.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arraySubject )
    }
}