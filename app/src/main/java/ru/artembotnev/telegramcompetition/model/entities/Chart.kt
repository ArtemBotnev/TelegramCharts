package ru.artembotnev.telegramcompetition.model.entities

data class Chart(
        val columns: List<List<String>>,
        val types: Map<String, String>,
        val names: Map<String, String>,
        val colors: Map<String, String>
)