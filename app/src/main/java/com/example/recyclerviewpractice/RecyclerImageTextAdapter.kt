package com.example.recyclerviewpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerImageTextAdapter(list: ArrayList<RecyclerItem>) : RecyclerView.Adapter<RecyclerImageTextAdapter.ViewHolder>(){
    private val mData = list

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var icon = itemView.findViewById<ImageView>(R.id.icon)
        var title = itemView.findViewById<TextView>(R.id.title)
        var desc = itemView.findViewById<TextView>(R.id.desc)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: RecyclerItem = mData[position]

        holder.icon.setImageDrawable(item.iconDrawable)
        holder.title.text = item.titleStr
        holder.desc.text = item.descStr
    }

    override fun getItemCount(): Int = mData.size
}