package es.jesuitas.dam.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import es.jesuitas.dam.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = NumberListAdapter(MyListener { num ->
            Toast.makeText(this,
                "El número seleccionado es el ${num}",
                Toast.LENGTH_LONG)
                .show()
        })

        binding.rv.adapter = adapter

        val manager = GridLayoutManager(this, 3,
                GridLayoutManager.VERTICAL, false)

        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0,1,2 -> 3
                    else -> 1
                }
            }
        }

        binding.rv.layoutManager = manager

        adapter.submitList(IntRange(0,100).toList())
    }
}