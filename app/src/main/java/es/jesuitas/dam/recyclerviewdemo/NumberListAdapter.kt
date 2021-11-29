package es.jesuitas.dam.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.jesuitas.dam.recyclerviewdemo.databinding.ActivityMainBinding
import es.jesuitas.dam.recyclerviewdemo.databinding.ItemViewBinding

class NumberListAdapter :
    ListAdapter<Int, NumberListAdapter.IntViewHolder>(RowItemDiffCallback()) {

    class IntViewHolder private constructor(val binding: ItemViewBinding):
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): IntViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
                return IntViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        return IntViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {

        holder.binding.num = getItem(position)
        holder.binding.executePendingBindings()
    }

}

class RowItemDiffCallback : DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }
}



