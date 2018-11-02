package ar.com.wolox.android.example.ui.newsDetail

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.facebook.drawee.backends.pipeline.Fresco


class NewsDetailFragment: WolmoFragment<NewsDetailPresenter>(), INewsDetailView{
    private lateinit var mTitle:TextView
    private lateinit var mNewsDescription:TextView
    private lateinit var mNewsTime:TextView
    private lateinit var mNewsImage:ImageView
    private lateinit var mNewsLike:ImageView
    lateinit var title:String
    lateinit var newsDescription:String
    lateinit var newsTime:String
    lateinit var newsImage:String


    companion object  {
        fun instance(bundle: Bundle):NewsDetailFragment{
            val newDetailsFragment=NewsDetailFragment()
            newDetailsFragment.arguments=bundle
            return  newDetailsFragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Fresco.initialize(activity)
        super.onCreate(savedInstanceState)
        title = savedInstanceState?.getString("Title")!!
        newsDescription = savedInstanceState?.getString("Description")!!
        newsTime = savedInstanceState?.getString("Time")!!
        newsImage= savedInstanceState?.getString("Image")!!
    }
    override fun layout(): Int = R.layout.fragment_newsdetail

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP) //PREGUNTAR
    override fun init() {
        mTitle= activity!!.findViewById<TextView>(R.id.vNewsDetailTitle)
        mNewsDescription=activity!!.findViewById<TextView>(R.id.vNewsDetailDescription)
        mNewsTime=activity!!.findViewById<TextView>(R.id.vNewsDetailTime)
        mNewsImage=activity!!.findViewById<ImageView>(R.id.vNewsDetailImage)
        mNewsLike=activity!!.findViewById<ImageView>(R.id.vNewsDetailLike)
        mTitle.text=title
        mNewsDescription.text=newsDescription
        mNewsTime.text=newsTime
        mNewsImage.setImageURI(Uri.parse(newsImage))
        val toolbar:Toolbar= activity!!.findViewById(R.id.toolbar)
        activity!!.setActionBar(toolbar)
        val actionBar = activity!!.actionBar
        actionBar.setDisplayHomeAsUpEnabled(true)
        mNewsLike.setOnClickListener {
            mNewsLike.isSelected=!mNewsLike.isSelected
        }
    }
}