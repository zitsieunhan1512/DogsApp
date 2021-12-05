package com.example.angelnminutes.util

import android.app.DatePickerDialog
import android.content.Context
import com.example.angelnminutes.MainActivity
import java.util.*

class Utils {
    companion object{
        fun clickDatePicker(mainActivity: MainActivity) {

            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)

            val dpd = DatePickerDialog(mainActivity, mainActivity, year, month, day).apply {
                datePicker.maxDate = Date().time - 86400000
                show()
            }
        }
    }
}