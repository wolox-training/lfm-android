package ar.com.wolox.android.example.ui.home

import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.adapters.NewsAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject


class   NewsFragment @Inject constructor() :  WolmoFragment<NewsPresenter>(), INewsView, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mRecyclerViewHorizontal:RecyclerView;
    private lateinit var mFragmentRecycleAdapter: NewsAdapter
    private lateinit var  mLayoutManager: LinearLayoutManager
    private lateinit var  mLayoutManager2: LinearLayoutManager
    private lateinit var fab:FloatingActionButton
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private lateinit var  mLineDividerDecoration:DividerItemDecoration
    private  var N_ITEMS_TO_REFRESH=5
    private lateinit var newsList: List<News>

    override fun layout(): Int = R.layout.fragment_news

    override fun init() {
        newsList= listOf()
        newsList=presenter.initialLoad()
        initFabButton()
        initRecyclerView()
        mFragmentRecycleAdapter.addDataSet(newsList)
    }

    override fun onRefresh() {
        val toast = Toast.makeText(context, activity!!.resources.getString(R.string.home_news_onPullRefresh_Toast), Toast.LENGTH_LONG)
        toast.show()
        newsList= presenter.updateNews(5)
        mFragmentRecycleAdapter.addDataSet(newsList)
        mFragmentRecycleAdapter.notifyDataSetChanged()
        mSwipeRefreshLayout.isRefreshing=false
    }
     override fun setErrorCode(i: Int) {
        val toastError = Toast.makeText(context, " ", Toast.LENGTH_LONG)
        when (i) {
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
    private fun initFabButton(){
        fab = activity!!.findViewById(R.id.fab)
        fab.show()
    }
    private fun initRecyclerView(){
        mSwipeRefreshLayout=activity!!.findViewById(R.id.vRefresh)
        mSwipeRefreshLayout.setOnRefreshListener(this)
        mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager2= LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        mFragmentRecycleAdapter=NewsAdapter()
        mLineDividerDecoration=DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        mRecyclerView= activity!!.findViewById<RecyclerView>(R.id.vNewsRecycler).apply {
            setHasFixedSize(false)
            layoutManager=mLayoutManager
            adapter=mFragmentRecycleAdapter
        }
        mRecyclerViewHorizontal= activity!!.findViewById<RecyclerView>(R.id.horizontalRecycler).apply {
            setHasFixedSize(false)
            layoutManager=mLayoutManager2
            adapter=mFragmentRecycleAdapter
        }
        mRecyclerView.addItemDecoration(mLineDividerDecoration)
        mRecyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var visibleItems=mLayoutManager.childCount
                var totalItems=mLayoutManager.itemCount
                var firstItem=mLayoutManager.findFirstVisibleItemPosition()
                if (firstItem < (firstItem+(visibleItems-N_ITEMS_TO_REFRESH)) ){

                    newsList=presenter.loadNmoreNews(N_ITEMS_TO_REFRESH)
                    mFragmentRecycleAdapter.addDataSet(newsList)
                }
                mFragmentRecycleAdapter.notifyDataSetChanged()
            }
        })
        mRecyclerViewHorizontal.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var visibleItems=mLayoutManager2.childCount
                var totalItems=mLayoutManager2.itemCount
                var firstItem=mLayoutManager2.findFirstVisibleItemPosition()
                if (firstItem < (firstItem+(visibleItems-N_ITEMS_TO_REFRESH)) ){

                    newsList=presenter.loadNmoreNews(N_ITEMS_TO_REFRESH)
                    mFragmentRecycleAdapter.addDataSet(newsList)
                }
                mFragmentRecycleAdapter.notifyDataSetChanged()
            }
        })
        mRecyclerView.isNestedScrollingEnabled=false
        mRecyclerViewHorizontal.isNestedScrollingEnabled=false
        mRecyclerViewHorizontal.setHasFixedSize(true)
        mRecyclerView.setHasFixedSize(false)
    }


}

