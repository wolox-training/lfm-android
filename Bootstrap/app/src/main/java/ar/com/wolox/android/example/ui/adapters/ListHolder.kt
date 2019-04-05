package ar.com.wolox.android.example.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import ar.com.wolox.android.R

class ListHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView: TextView = itemView!!.findViewById(R.id.textView3)
}