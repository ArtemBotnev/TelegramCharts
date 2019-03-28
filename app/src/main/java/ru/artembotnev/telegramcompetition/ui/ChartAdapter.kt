package ru.artembotnev.telegramcompetition.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.artembotnev.telegramcompetition.R
import ru.artembotnev.telegramcompetition.model.entities.Chart

class ChartAdapter(private val charts: List<Chart>)
    : RecyclerView.Adapter<ChartAdapter.ChartViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ChartViewHolder(LayoutInflater.from(parent.context), parent)

    override fun getItemCount() = charts.size

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) =
        holder.onBind(charts[position])

    inner class ChartViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_chart, parent, false)) {

        fun onBind(c: Chart) {
            itemView.findViewById<ChartView>(R.id.chart_view).run {
                chart = c
            }
        }
    }
}