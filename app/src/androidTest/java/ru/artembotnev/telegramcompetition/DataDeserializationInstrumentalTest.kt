package ru.artembotnev.telegramcompetition

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Test
import org.junit.runner.RunWith
import ru.artembotnev.telegramcompetition.model.Chart

@RunWith(AndroidJUnit4::class)
class DataDeserializationInstrumentalTest {

    companion object {
        private const val SOURCE_FILE_NAME = "chart_data.json"
        private const val TAG = "DataDeserializationInstrumentalTest"
    }

    val context = InstrumentationRegistry.getInstrumentation().context

    @Test
    fun getDataFromJsonAndCheck() {
        val jsonString = context.assets.readFile(SOURCE_FILE_NAME)

        val data: List<Chart> = GsonBuilder().create()
                .fromJson(jsonString, object : TypeToken<List<Chart>>() {}.type)

        Log.i(TAG, "charts count: ${data.size}")

    }
}