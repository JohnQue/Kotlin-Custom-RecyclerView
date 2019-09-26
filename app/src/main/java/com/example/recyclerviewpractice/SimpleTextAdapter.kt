package com.example.recyclerviewpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleTextAdapter(list: ArrayList<String>) : RecyclerView.Adapter<SimpleTextAdapter.ViewHolder>(){
    var mData = list

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textView = itemView.findViewById<TextView>(R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = mData[position]
    }

    override fun getItemCount(): Int = mData.size

}
