package com.scaler.droidmc22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnAdd.setOnClickListener {
            try {
                val num1 = etNum1.text.toString().toInt()
                val num2 = etNum2.text.toString().toInt()
                val sum = num1 + num2
                tvResult.text = "RESULT: $sum"
            } catch (e: NumberFormatException) {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please enter a valid number")
                    .setPositiveButton("OK", null)
                    .show()
            }



        }

    }

}