package es.jesuitas.dam.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import es.jesuitas.dam.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = NumberListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.adapter = adapter
        binding.rv.layoutManager = GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false)

        adapter.submitList(IntRange(0,100).toList())
    }
}