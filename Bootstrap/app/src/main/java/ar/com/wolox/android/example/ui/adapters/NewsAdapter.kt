package ar.com.wolox.android.example.ui.adapters

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import com.facebook.drawee.view.SimpleDraweeView
import org.ocpsoft.prettytime.PrettyTime
import java.text.SimpleDateFormat

class NewsAdapter(private val myDataset: MutableList<News>) :
        RecyclerView.Adapter<NewsAdapter.NewsHolder>(){
    class NewsHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var newsTitle: TextView = itemView!!.findViewById(R.id.news_textHeader)
        var newsText: TextView = itemView!!.findViewById(R.id.news_textDescription)
        var newsPhoto:SimpleDraweeView=itemView!!.findViewById(R.id.news_photo)
        var newsTime:TextView=itemView!!.findViewById(R.id.news_time)
        var like:ImageView=itemView!!.findViewById(R.id.vLikeButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_news, parent, false))
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val prettyTime = PrettyTime()
        val simpleDateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        val simpleDateFormat = SimpleDateFormat(simpleDateFormatPattern)
        holder.newsPhoto.setImageURI(Uri.parse(myDataset[position].picture),this)
        holder.newsTitle.text = myDataset[position].title+position
        holder.newsTime.text = prettyTime.format(simpleDateFormat.parse(myDataset[position].createdAt))
        holder.newsText.text = myDataset[position].text
        holder.like.isSelected = myDataset[position].like
        holder.like.setOnClickListener {
            holder.like.isSelected=!holder.like.isSelected
        }
    }

}
