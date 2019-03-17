package ru.artembotnev.telegramcompetition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import ru.artembotnev.telegramcompetition.model.Chart

class MainActivity : AppCompatActivity() {

    companion object {
        private const val SOURCE_FILE_NAME = "chart_data.json"
        private const val TAG = "MainActivity"
    }

    private lateinit var data: List<Chart>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = assets.readFile(SOURCE_FILE_NAME)
        Log.i(TAG, jsonString)

        data = GsonBuilder().create()
                .fromJson(jsonString, object : TypeToken<List<Chart>>() {}.type)
    }
}
