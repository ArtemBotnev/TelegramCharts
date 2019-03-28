package ru.artembotnev.telegramcompetition.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import ru.artembotnev.telegramcompetition.model.entities.Chart

class ChartView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    var chart: Chart? = null
        set(value) {
            field = value
            invalidate()
        }

    private var w = .0f
    private var h = .0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        w = width.toFloat()
        h = height.toFloat()

        chart?.let { drawChart(it, canvas) }
    }

    private fun drawChart(chart: Chart, canvas: Canvas) {
        val times = chart.columns[0]
                .asSequence()
                .drop(1)
                .map { it.toLong() }
                .toList()

        val xList = getXPoints(times)

        val allYList = chart.columns
                .asSequence()
                .drop(1)
                .flatMap { it.drop(1).asSequence() }
                .map { it.toFloat() }
                .toList()

        val yDelta = allYList.max()!! - allYList.min()!!
        val yStep = h / yDelta

        val yMap = getYMap(
            chart.columns.drop(1),
            yStep,
            allYList.min()!!
        )

        yMap.forEach { (k, v) ->
            for (i in 0..xList.size - 2) {
                val paint = createPaint(chart.colors[k])
                canvas.drawLine(xList[i], v[i], xList[i + 1], v[i + 1], paint)
            }
        }
    }

    private fun getXPoints(times: List<Long>): List<Float> {
        val timeDelta = times.last() - times.first()
        val timeStep = timeDelta / w

        return times.map { (it - times[0]) / timeStep }
    }

    private fun getYMap(values: List<List<String>>, step: Float, yMin: Float):
            Map<String, List<Float>> {

        val map = mutableMapOf<String, List<Float>>()

        values.forEach { list ->
            val key = list[0]
            val floatList = list
                    .asSequence()
                    .drop(1)
                    .map { it.toFloat() }
                    .map { h - ((it - yMin) * step) }
                    .toList()

            map[key] = floatList
        }

        return map.toMap()
    }

    private fun createPaint(colorString: String?) =
            Paint().apply {
                color = Color.parseColor(colorString ?: "#000000")
                strokeWidth = 3.0f
            }
}