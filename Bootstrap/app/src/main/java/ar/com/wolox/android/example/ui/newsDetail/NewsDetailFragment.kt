package ar.com.wolox.android.example.ui.newsDetail

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.facebook.drawee.backends.pipeline.Fresco
import org.ocpsoft.prettytime.PrettyTime
import java.text.SimpleDateFormat


class NewsDetailFragment: WolmoFragment<NewsDetailPresenter>(), INewsDetailView{
    private var mTitle= activity!!.findViewById<TextView>(R.id.vNewsDetailTitle)
    private var mNewsDescription=activity!!.findViewById<TextView>(R.id.vNewsDetailDescription)
    private var mNewsTime=activity!!.findViewById<TextView>(R.id.vNewsDetailTime)
    private var mNewsImage=activity!!.findViewById<ImageView>(R.id.vNewsDetailImage)
    private var mNewsLike=activity!!.findViewById<ImageView>(R.id.vNewsDetailLike)
    companion object  {
        fun instance(newsDetail: News):NewsDetailFragment{
            val newDetailsFragment=NewsDetailFragment()
            var bundle=Bundle()
            val prettyTime = PrettyTime()
            val simpleDateFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            val simpleDateFormat = SimpleDateFormat(simpleDateFormatPattern)
            bundle.putString("Title", newsDetail.title)
            bundle.putString("Description", newsDetail.text)
            bundle.putString("Image",newsDetail.picture)
            bundle.putString("Time",prettyTime.format(simpleDateFormat.parse(newsDetail.createdAt)))
            newDetailsFragment.arguments=bundle
            return  newDetailsFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Fresco.initialize(activity)
        super.onCreate(savedInstanceState)
        mTitle.text = savedInstanceState?.getString("Title")
        mNewsDescription.text = savedInstanceState?.getString("Description")
        mNewsTime.text = savedInstanceState?.getString("Time")
        mNewsImage.setImageURI(Uri.parse(savedInstanceState?.getString("Image")))
    }
    override fun layout(): Int = R.layout.fragment_newsdetail

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun init() {
        val toolbar:Toolbar= activity!!.findViewById(R.id.toolbar)
        activity!!.setActionBar(toolbar)
        val actionBar = activity!!.actionBar
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}