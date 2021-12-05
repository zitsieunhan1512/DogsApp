package com.example.intentkpt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkpt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.buttonIntent.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity2::class.java)
//            intent.putExtra("data", "Mai Bảo Long") //truyền chuỗi
            val student : Student = Student ("Mai Bao Long", 19)
            intent.putExtra("data", student)
            startActivity(intent)
        }

    }
}