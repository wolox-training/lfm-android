package ar.com.wolox.android.example.ui.newsDetail

import android.app.ActionBar
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.widget.SwipeRefreshLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment


class NewsDetailFragment: WolmoFragment<NewsDetailPresenter>(), INewsDetailView, SwipeRefreshLayout.OnRefreshListener {
    private lateinit var mTitle: TextView
    private lateinit var mNewsDescription: TextView
    private lateinit var mNewsTime: TextView
    private lateinit var mNewsImage: ImageView
    private lateinit var mNewsLike: ImageView
    private lateinit var mToolbar:Toolbar
    private lateinit var mActionBar: ActionBar
    private lateinit var mSwipeRefreshLayout:SwipeRefreshLayout

    companion object {
        fun instance(bundle: Bundle): NewsDetailFragment {
            val newDetailsFragment = NewsDetailFragment()
            newDetailsFragment.arguments = bundle
            return newDetailsFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun layout(): Int = R.layout.fragment_newsdetail

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun init() {
        bindViews()
        setToolbar()
        loadNewsDetails()
        mSwipeRefreshLayout.setOnRefreshListener(this)
        mNewsLike.setOnClickListener {
            mNewsLike.isSelected = !mNewsLike.isSelected
        }
    }

    override fun onRefresh() {
        val toast = Toast.makeText(context, "Refreshing News", Toast.LENGTH_LONG)
        toast.show()
        mSwipeRefreshLayout.isRefreshing=false
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun bindViews() {
        mSwipeRefreshLayout=activity!!.findViewById(R.id.vNewsDetailSwipeRefreshLayout)
        mTitle = activity!!.findViewById(R.id.vNewsDetailTitle)
        mNewsDescription = activity!!.findViewById(R.id.vNewsDetailDescription)
        mNewsTime = activity!!.findViewById(R.id.vNewsDetailTime)
        mNewsImage = activity!!.findViewById(R.id.vNewsDetailImage)
        mNewsLike = activity!!.findViewById(R.id.vNewsDetailLike)
        mToolbar = activity!!.findViewById(R.id.vNewsDetailToolbar)
    }

    private fun loadNewsDetails(){
        mTitle.text = arguments!!.getString("Title")!!
        mNewsDescription.text = arguments!!.getString("Description")!!
        mNewsTime.text = arguments!!.getString("Time")!!
        mNewsImage.setImageURI(Uri.parse(arguments!!.getString("Image")))
        mNewsLike.isSelected= arguments!!.getBoolean("Like")
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setToolbar(){
        activity!!.setActionBar(mToolbar)
        mActionBar = activity!!.actionBar
        mActionBar.setDisplayHomeAsUpEnabled(true)
        mToolbar.setNavigationOnClickListener {
            var intent= Intent(activity,HomeActivity()::class.java)
            startActivity(intent)
            activity!!.finish()
        }
    }
}