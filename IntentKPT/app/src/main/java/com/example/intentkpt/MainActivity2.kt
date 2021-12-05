package com.example.intentkpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkpt.databinding.ActivityMain2Binding
import com.example.intentkpt.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //Nhận dữ liệu từ content
        val intent = intent
//        val name: String? = intent.getStringExtra("data")
        val student: Student = intent.getSerializableExtra("data") as Student
        viewBinding.txtContent.text = student.name + " - " + student.age

    }
}