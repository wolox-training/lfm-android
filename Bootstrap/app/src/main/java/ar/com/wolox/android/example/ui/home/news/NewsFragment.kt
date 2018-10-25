package ar.com.wolox.android.example.ui.home

import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.adapters.NewsAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject



class NewsFragment @Inject constructor() :  WolmoFragment<ProfilePresenter>(), INewsView {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mFragmentRecycleAdapter: NewsAdapter
    private lateinit var  mLayoutManager: RecyclerView.LayoutManager
    private lateinit var testData:NewsPresenter.NewsData
    private var myDataSet= arrayListOf<NewsPresenter.NewsData>()
    private lateinit var fab:FloatingActionButton

    override fun layout(): Int = R.layout.fragment_news
    override fun init() {

        fab = activity!!.findViewById(R.id.fab)
        fab.show()
        val imagen=R.drawable.wlogo
        testData=NewsPresenter.NewsData("Titulo","Header",imagen)
        for (i in 1..15) myDataSet.add(testData)
        mLayoutManager=LinearLayoutManager(activity)
        mFragmentRecycleAdapter=NewsAdapter(myDataSet)
        val itemDecoration =DividerItemDecoration(context,VERTICAL)
        mRecyclerView= activity!!.findViewById<RecyclerView>(R.id.vNewsRecycler).apply {
            layoutManager=mLayoutManager
            adapter=NewsAdapter(myDataSet)
        }
        mRecyclerView.addItemDecoration(itemDecoration)

    }

}

