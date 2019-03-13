package ru.artembotnev.telegramcompetition

import android.content.res.AssetManager

fun AssetManager.readFile(fileName: String) = open(fileName)
    .bufferedReader()
    .use { it.readText() }