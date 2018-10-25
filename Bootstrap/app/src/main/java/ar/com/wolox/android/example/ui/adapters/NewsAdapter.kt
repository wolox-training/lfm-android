package ar.com.wolox.android.example.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.home.NewsPresenter

class NewsAdapter(private val myDataset: ArrayList<NewsPresenter.NewsData>) :
        RecyclerView.Adapter<NewsAdapter.NewsHolder>(){
    class NewsHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var newsImage: ImageView = itemView!!.findViewById(R.id.news_imageView)
        var newsTitle: TextView = itemView!!.findViewById(R.id.news_textHeader)
        var newsText: TextView = itemView!!.findViewById(R.id.news_textDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_news, parent, false))
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.newsImage.setImageResource(myDataset.get(position).image)
        holder.newsTitle.setText(myDataset.get(position).newsHeader)
        holder.newsText.setText(myDataset.get(position).newsDescription)
    }
}
