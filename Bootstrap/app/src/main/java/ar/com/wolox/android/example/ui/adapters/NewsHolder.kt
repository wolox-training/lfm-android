package ar.com.wolox.android.example.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import ar.com.wolox.android.R
import com.facebook.drawee.view.SimpleDraweeView

class NewsHolder(itemView: View?)  : RecyclerView.ViewHolder(itemView){
        var newsTitle: TextView = itemView!!.findViewById(R.id.news_textHeader)
        var newsText: TextView = itemView!!.findViewById(R.id.news_textDescription)
        var newsPhoto: SimpleDraweeView =itemView!!.findViewById(R.id.news_photo)
        var newsTime: TextView =itemView!!.findViewById(R.id.news_time)
        var like: ImageView =itemView!!.findViewById(R.id.vLikeButton)
}