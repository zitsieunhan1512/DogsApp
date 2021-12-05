package com.example.angelnminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import com.example.angelnminutes.databinding.ActivityMainBinding
import com.example.angelnminutes.util.Utils
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() ,DatePickerDialog.OnDateSetListener{

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnDatePicker.setOnClickListener {_ ->
            Utils.clickDatePicker(this)
        }
    }

    override fun onDateSet(p0: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int) {
        Toast.makeText(
            this, "The year is $selectedYear" +
                    ", the month is ${selectedMonth + 1}" +
                    ", the day of month is $selectedDayOfMonth", Toast.LENGTH_LONG
        ).show()

        val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

        viewBinding.tvSelectedDate.text = selectedDate

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

        val theDate = sdf.parse(selectedDate)

        val selectedDateInMinutes = theDate!!.time / 86400000

        val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

        val currentDateToMinutes = currentDate!!.time / 86400000

        val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes

        viewBinding.tvSelectedDateInMinutes.text = differenceInMinutes.toString()
    }


}