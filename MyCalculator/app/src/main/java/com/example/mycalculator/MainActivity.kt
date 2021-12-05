package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    var lastNumberic: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
    
    fun onDigit(view: View) {
        viewBinding.tvInput.append((view as Button).text)
        lastNumberic = true
    }

    fun onClear(view: View) {
        viewBinding.tvInput.text = ""
        lastNumberic = false
        lastDot = false
    }

    fun onDecimalPoint(view: View) {
        if (lastNumberic && !lastDot) {
            viewBinding.tvInput.append(".")
            lastNumberic = false
            lastDot = true
        }
    }

    fun onEqual(view: View) {
        if (lastNumberic) {
            var tvValue = viewBinding.tvInput.text.toString()

            try {
                tvValue = tvValue.replace(" ", "")
                var kt=false
                if(tvValue.startsWith("-")){
                    tvValue=tvValue.drop(1)
                    kt=true
                }
                var splitValue : List<String>
                splitValue=tvValue.split("-")
                if (tvValue.contains("+"))
                    splitValue = tvValue.split("+")
                if (tvValue.contains("*"))
                    splitValue = tvValue.split("*")
                if (tvValue.contains("/"))
                    splitValue = tvValue.split("/")
                var one = splitValue[0].toDouble()
                var two = splitValue[1].toDouble()
                if (kt) one *= -1
                if (tvValue.contains("-")) {
                    two *= -1
                }
                if (tvValue.contains("*"))
                    viewBinding.tvInput.text=(one*two).toString()
                if (tvValue.contains("/"))
                    viewBinding.tvInput.text=(one/two).toString()
                else
                    viewBinding.tvInput.text=(one+two).toString()
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    fun onOperator(view: View) {
        if (lastNumberic && !isOperatorAdded(viewBinding.tvInput.text.toString())) {
            viewBinding.tvInput.append((view as Button).text)
            lastNumberic = false
            lastDot = false
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*")
                    || value.contains("+") || value.contains("-")
        }
    }
}