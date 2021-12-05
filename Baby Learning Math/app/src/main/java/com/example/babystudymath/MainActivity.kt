package com.example.babystudymath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textviewresult.setVisibility(View.INVISIBLE)
        buttonadd.setOnClickListener {
            try {
                var numberone: Int = (edittext1.text.toString()).toInt()
                var numbertwo: Int = (edittext2.text.toString()).toInt()
                var result: Int = numberone + numbertwo
                textviewresult.text = result.toString()
                textviewresult.setVisibility(View.VISIBLE)
            } catch (e: Exception) {
                Toast.makeText(this, "$e Chưa nhập dữ liệu vào", Toast.LENGTH_SHORT).show()
            }
        }

        buttonminus.setOnClickListener {
            try {
                var numberone: Int = (edittext1.text.toString()).toInt()
                var numbertwo: Int = (edittext2.text.toString()).toInt()
                var result: Int = numberone - numbertwo
                textviewresult.text = result.toString()
                textviewresult.setVisibility(View.VISIBLE)
            } catch (e: Exception) {
                Toast.makeText(this, "$e Chưa nhập dữ liệu vào", Toast.LENGTH_SHORT).show()
            }
        }

        buttonmultiply.setOnClickListener {
            try {
                var numberone: Int = (edittext1.text.toString()).toInt()
                var numbertwo: Int = (edittext2.text.toString()).toInt()
                var result: Int = numberone * numbertwo
                textviewresult.text = result.toString()
                textviewresult.setVisibility(View.VISIBLE)
            } catch (e: Exception) {
                Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
            }
        }

        buttondevide.setOnClickListener {
            try {
                var numberone: Int = (edittext1.text.toString()).toInt()
                var numbertwo: Int = (edittext2.text.toString()).toInt()
                var result: Int = numberone / numbertwo
                textviewresult.text = result.toString()
                textviewresult.setVisibility(View.VISIBLE)
            } catch (e: Exception) {
                Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
            }
        }
    }
}