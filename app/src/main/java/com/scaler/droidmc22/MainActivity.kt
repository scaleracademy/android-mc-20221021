package com.scaler.droidmc22

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val TAG = "LifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnGoToWait = findViewById<Button>(R.id.btnGoToWait)
        val btnGoToDisco = findViewById<Button>(R.id.btnGoToDisco)

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

        btnGoToWait.setOnClickListener {
            val intent = Intent(this, WaitActivity::class.java)
            startActivity(intent)
        }

        btnGoToDisco.setOnClickListener {
            val intent = Intent(this, DiscoActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

}