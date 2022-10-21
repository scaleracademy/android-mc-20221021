package com.scaler.droidmc22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class WaitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wait)

        var counter = 0

        val btnWait = findViewById<Button>(R.id.btnWait)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        val btnCount = findViewById<Button>(R.id.btnCount)
        val tvCount = findViewById<TextView>(R.id.tvCount)

        btnWait.setOnClickListener {
            tvMessage.text = "Wait for it..."

//            Handler().postDelayed({
//                tvMessage.text = "Done!"
//            }, 5000)

            Thread {
                Thread.sleep(5000)
                runOnUiThread {
                    tvMessage.text = "Done!"
                }
            }.start()

        }

        btnCount.setOnClickListener {
            counter++
            tvCount.text = counter.toString()
        }
    }
}