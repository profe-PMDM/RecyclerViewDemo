package es.jesuitas.dam.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberListAdapter(var data: List<Int>) :
    RecyclerView.Adapter<NumberListAdapter.IntViewHolder>() {

    class IntViewHolder(val row: View): RecyclerView.ViewHolder(row) {
        val textView = row.findViewById<TextView>(R.id.number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return IntViewHolder(layout)
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        holder.textView.text = data.get(position).toString()
    }

    override fun getItemCount() = data.size

}
