package ru.artembotnev.telegramcompetition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        private const val SOURCE_FILE_NAME = "chart_data.json"
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = assets.readFile(SOURCE_FILE_NAME)
        Log.i(TAG, jsonString)
    }
}
