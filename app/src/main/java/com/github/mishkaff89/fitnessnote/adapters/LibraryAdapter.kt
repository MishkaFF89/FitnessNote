package com.github.mishkaff89.fitnessnote.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mishkaff89.fitnessnote.R
import com.github.mishkaff89.fitnessnote.databinding.ActivityLibraryMainBinding
import com.github.mishkaff89.fitnessnote.databinding.ItemLibraryBinding
import com.github.mishkaff89.fitnessnote.entity.LibraryItem
import com.github.mishkaff89.fitnessnote.entity.TrainingItem

class LibraryAdapter(private val listener: Listener): RecyclerView.Adapter<LibraryAdapter.LibraryHolder>() {
    private val list = mutableListOf<LibraryItem>()

    class LibraryHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = ItemLibraryBinding.bind(item)

        fun setData(libraryItem: LibraryItem, listener: Listener) = with(binding){
            tvLibraryName.text = libraryItem.name

            editLibrary.setOnClickListener {
                listener.updateItem(libraryItem)
            }

            deleteLibrary.setOnClickListener {
                listener.deleteItem(libraryItem.id!!)
            }
        }
    }

    interface Listener{
        fun deleteItem(id: Int)
        fun updateItem(item: LibraryItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryHolder {
        val inflater = LayoutInflater.from(parent.context)
        return  LibraryHolder(inflater.inflate(R.layout.item_library, parent,false))
    }

    override fun onBindViewHolder(holder: LibraryHolder, position: Int) {
        list.sortByDescending { it.id }
        holder.setData(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItems: List<LibraryItem>){
        list.clear()
        list.addAll(listItems)
        notifyDataSetChanged()

    }
}