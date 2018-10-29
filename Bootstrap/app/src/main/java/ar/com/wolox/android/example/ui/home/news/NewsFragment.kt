package ar.com.wolox.android.example.ui.home

import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.adapters.NewsAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import com.facebook.drawee.backends.pipeline.Fresco
import javax.inject.Inject


class NewsFragment @Inject constructor() :  WolmoFragment<ProfilePresenter>(), INewsView, SwipeRefreshLayout.OnRefreshListener {


    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mFragmentRecycleAdapter: NewsAdapter
    private lateinit var  mLayoutManager: RecyclerView.LayoutManager
    private lateinit var testData:News
    private var myDataSet= arrayListOf<News>()
    private lateinit var fab:FloatingActionButton
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    override fun layout(): Int = R.layout.fragment_news
    override fun init() {
        Fresco.initialize(activity)
        mSwipeRefreshLayout=activity!!.findViewById(R.id.vRefresh)
        fab = activity!!.findViewById(R.id.fab)
        fab.show()
        mSwipeRefreshLayout.setOnRefreshListener(this)
        var mLikeButton=activity!!.findViewById<ImageView>(R.id.vLikeButton)

        //val imagen= Uri.parse("https://cdn-images-1.medium.com/fit/c/100/100/1*RIlH4dGIVDccLZ0JTH3lhg.png")
        //testData=NewsPresenter.NewsData("Titulo","descripcion...","2016-07-18T14:00:29.985Z",imagen)
        //for (i in 1..15) myDataSet.add(testData)

        mLayoutManager=LinearLayoutManager(activity)
        mFragmentRecycleAdapter=NewsAdapter(myDataSet)
        val mLineDividerDecoration =DividerItemDecoration(context,VERTICAL)
        mRecyclerView= activity!!.findViewById<RecyclerView>(R.id.vNewsRecycler).apply {
            setHasFixedSize(false)
            layoutManager=mLayoutManager
            adapter=NewsAdapter(myDataSet)
        }
        mRecyclerView.addItemDecoration(mLineDividerDecoration)
    }

    override fun onRefresh() {
        val toast = Toast.makeText(context, "Refreshing News", Toast.LENGTH_LONG)
        toast.show()
        //TRAER LAS NOTICIAS NUEVAS

        mSwipeRefreshLayout.isRefreshing=false

    }

     override fun setErrorCode(code: Int) {
        val toastError = Toast.makeText(context, " ", Toast.LENGTH_LONG)
        when (code) {
            1 -> {
                toastError.setText(activity!!.resources.getString(R.string.noNewNews))
                toastError.show()
            }
            2 -> {
                toastError.setText(activity!!.resources.getString(R.string.serverError))
                toastError.show()
            }

            3 -> {
                toastError.setText(activity!!.resources.getString(R.string.noConnection))
                toastError.show()
            }

        }
    }
    override fun updateXNewNews(list: List<News>, itemCount: Int) {
        var  lastPosition=myDataSet.size
        if (myDataSet.addAll(list)){
            val oldDataSet=myDataSet.set(lastPosition)
            mFragmentRecycleAdapter.notifyDataSetChanged()
        }
    }
    override fun addXOlderNews(list: List<News>, X: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

