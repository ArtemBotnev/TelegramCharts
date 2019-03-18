package ru.artembotnev.telegramcompetition.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager

class ChartView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    private val paint = Paint()
    private var screenHeight: Float = .0f
    private var screenWidth: Float = .0f

    init {
        paint.apply {
            color = Color.BLACK
            strokeWidth = 7.0f
        }

        val metrics = DisplayMetrics().also {
            val windowManager =
                    context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

            windowManager.defaultDisplay.getMetrics(it)
        }

        screenHeight = metrics.heightPixels.toFloat()
        screenWidth = metrics.widthPixels.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawLine(.0f, .0f,
                screenWidth, screenHeight / 2,
                paint
        )
        canvas.drawLine(screenWidth, screenHeight  / 2,
                .0f, screenHeight,
                paint)
    }
}