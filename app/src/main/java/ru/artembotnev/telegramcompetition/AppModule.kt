package ru.artembotnev.telegramcompetition

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.artembotnev.telegramcompetition.ui.MainViewModel

val appModule = module {
    single<Repository> { RepositoryImpl(get()) }
    viewModel { MainViewModel(get()) }
}