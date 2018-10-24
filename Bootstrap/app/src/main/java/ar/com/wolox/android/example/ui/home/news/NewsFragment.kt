package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() :  WolmoFragment<ProfilePresenter>(), INewsView {

    override fun layout(): Int = R.layout.fragment_news

    override fun init() {

    }

}
