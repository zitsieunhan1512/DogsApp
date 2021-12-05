package com.example.demostartactivityforresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demostartactivityforresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding

    companion object{
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}