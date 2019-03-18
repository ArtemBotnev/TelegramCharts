package ru.artembotnev.telegramcompetition

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.artembotnev.telegramcompetition.model.entities.Chart

@RunWith(AndroidJUnit4::class)
class DataDeserializationInstrumentalTest {

    companion object {
        private const val SOURCE_FILE_NAME = "chart_data.json"
    }

    @get:Rule
    val activityRule: ActivityTestRule<MainActivity> =
            ActivityTestRule(MainActivity::class.java)

    @Test
    fun getDataFromJsonAndCheck() {
        val jsonString = activityRule.activity
            .assets.readFile(SOURCE_FILE_NAME)

        val data: List<Chart> = GsonBuilder().create()
                .fromJson(jsonString, object : TypeToken<List<Chart>>() {}.type)

        assertEquals("x", data[0].columns[0][0])
        assertEquals(1542412800000L, data[0].columns[0][1].toLong())
        assertEquals("#F34C44", data[3].colors["y1"])
    }
}