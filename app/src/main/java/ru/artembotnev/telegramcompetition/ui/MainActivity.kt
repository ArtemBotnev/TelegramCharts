package ru.artembotnev.telegramcompetition.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import ru.artembotnev.telegramcompetition.R
import ru.artembotnev.telegramcompetition.model.entities.Chart
import ru.artembotnev.telegramcompetition.readFile

class MainActivity : AppCompatActivity() {

    companion object {
        private const val SOURCE_FILE_NAME = "chart_data.json"
    }

    private lateinit var data: List<Chart>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = assets.readFile(SOURCE_FILE_NAME)

        data = GsonBuilder().create()
                .fromJson(jsonString, object : TypeToken<List<Chart>>() {}.type)

        adjustRecycler()
    }

    private fun adjustRecycler() {
        recycler.run {
            layoutManager = LinearLayoutManager(this@MainActivity,
                RecyclerView.VERTICAL,
                false
            )
            adapter = ChartAdapter(data)
        }
    }
}
