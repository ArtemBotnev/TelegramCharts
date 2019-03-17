package ru.artembotnev.telegramcompetition.model

data class Chart(
        val columns: List<Map<String, String>>,
        val types: Map<String, String>,
        val names: Map<String, String>,
        val colorsMap: Map<String, String>
)

//data class Column(val dataMap: Map<Int, Any>)