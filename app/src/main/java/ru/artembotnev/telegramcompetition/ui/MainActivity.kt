package ru.artembotnev.telegramcompetition.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.artembotnev.telegramcompetition.R

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adjustRecycler()
    }

    private fun adjustRecycler() {
        recycler.run {
            layoutManager = LinearLayoutManager(this@MainActivity,
                RecyclerView.VERTICAL,
                false
            )
            adapter = ChartAdapter(viewModel.charts)
        }
    }
}
