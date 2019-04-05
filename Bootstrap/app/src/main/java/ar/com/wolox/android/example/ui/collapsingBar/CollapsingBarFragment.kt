package ar.com.wolox.android.example.ui.collapsingBar

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.adapters.CollapsingBarAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class CollapsingBarFragment: WolmoFragment<CollapsingBarPresenter>() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mFragmentRecycleAdapter: CollapsingBarAdapter
    private lateinit var  mLayoutManager: LinearLayoutManager
    private lateinit var  mLineDividerDecoration:DividerItemDecoration

    override fun layout(): Int = R.layout.fragment_collapsingbar

    override fun init() {
        mLayoutManager = LinearLayoutManager(activity)
        mFragmentRecycleAdapter=CollapsingBarAdapter()
        mLineDividerDecoration= DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        mRecyclerView= activity!!.findViewById<RecyclerView>(R.id.vRecyclerView).apply {
            setHasFixedSize(true)
            layoutManager=mLayoutManager
            adapter=mFragmentRecycleAdapter
        }
        mRecyclerView.addItemDecoration(mLineDividerDecoration)
    }
}

