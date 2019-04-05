package ar.com.wolox.android.example.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ar.com.wolox.android.R

class CollapsingBarAdapter: RecyclerView.Adapter<ListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(LayoutInflater.from(parent.context).inflate(R.layout.collapsing_bar_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
       // holder.textView.text="WELCOME TO WOLOX"
    }
}