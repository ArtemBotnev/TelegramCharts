package ru.artembotnev.telegramcompetition.ui

import androidx.lifecycle.ViewModel
import ru.artembotnev.telegramcompetition.Repository
import ru.artembotnev.telegramcompetition.model.entities.Chart

class MainViewModel(repository: Repository) : ViewModel() {
    val charts: List<Chart> by lazy { repository.getCharts() }
}