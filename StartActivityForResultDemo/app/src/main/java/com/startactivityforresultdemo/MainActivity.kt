package com.startactivityforresultdemo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    // TODO (STEP 6 : Add the request code in the companion object for launching the activities.)
    // START
    companion object {
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        const val NAME = "name"
        const val EMAIL = "email"
    }
    // END

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO (STEP 7: Add click events and launch the respective activities with request codes.)
        //START
        btn_launch_activity_first.setOnClickListener {
            val intent = Intent(this@MainActivity, FirstActivity::class.java)
            startActivityForResult(
                intent,
                FIRST_ACTIVITY_REQUEST_CODE
            ) // Activity is started with requestCode
        }

        btn_launch_activity_second.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivityForResult(
                intent,
                SECOND_ACTIVITY_REQUEST_CODE
            ) // Activity is started with requestCode
        }
        // END
    }

    // TODO (STEP 10: This method is used to get the result from the activity which are launched with request code. And result can be used as per requirement.)
    // START
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == FIRST_ACTIVITY_REQUEST_CODE) {
                // It is if the result of First Activity is success.
                tv_first_activity_result.text = "First Activity Result Success."
            }else if(requestCode == SECOND_ACTIVITY_REQUEST_CODE){
                if (data != null) {
                    // Here the data which we have sent from the second activity is received and displayed in the textview.
                    val name = data.getStringExtra(NAME)
                    val email = data.getStringExtra(EMAIL)

                    tv_second_activity_result.text = "$name  ==>  $email"
                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(this@MainActivity,"Result Cancelled",Toast.LENGTH_SHORT).show()
        }
    }
    // END
}
