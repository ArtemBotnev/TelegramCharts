package ru.artembotnev.telegramcompetition

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import ru.artembotnev.telegramcompetition.model.entities.Chart

interface Repository {
    fun getCharts(): List<Chart>
}

class RepositoryImpl(private val context: Context) : Repository {

    companion object {
        private const val SOURCE_FILE_NAME = "chart_data.json"
    }

    override fun getCharts(): List<Chart> {
        val jsonString = context.assets.readFile(SOURCE_FILE_NAME)

        return GsonBuilder().create()
            .fromJson(jsonString, object : TypeToken<List<Chart>>() {}.type)
    }
}