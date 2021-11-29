package es.jesuitas.dam.recyclerviewdemo

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("base2Number")
fun TextView.setBase2Number(item: Int) {
    text = Integer.toBinaryString(item)
}
