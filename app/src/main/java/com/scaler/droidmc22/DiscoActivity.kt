package com.scaler.droidmc22

import android.graphics.Color
import android.hardware.*
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class DiscoActivity : AppCompatActivity() {

    lateinit var flBackground: FrameLayout
    val TAG = "SENSOR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disco)

        flBackground = findViewById(R.id.flBackground)

        val sensorManager = getSystemService(SensorManager::class.java)

        val accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensorManager.registerListener(
            object: SensorEventListener {
                override fun onSensorChanged(p0: SensorEvent?) {
                    p0?.let {
                        val ax = it.values[0]
                        val ay = it.values[1]
                        val az = it.values[2]

                        val bgColor = accelToColor(ax, ay, az)
                        flBackground.setBackgroundColor(bgColor)
                    }
                }

                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                    // TODO: nothing to do here for now
                }
            },
            accelSensor,
            1000 * 1000 * 1 // 1 millisecond
        )

    }

    fun accelToColor(ax: Float, ay: Float, az: Float): Int {
        val r = ((ax + 11) / 22) * 255
        val g = ((ay + 11) / 22) * 255
        val b = ((az + 11) / 22) * 255
        return Color.rgb(r.toInt(), g.toInt(), b.toInt())
    }
}