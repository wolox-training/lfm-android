package ar.com.wolox.android.example.ui.viewpagerMotion.page1

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class Page1Fragment @Inject constructor(): WolmoFragment<Page1Presenter>(), IPage1View  {
    override fun layout(): Int = R.layout.fragment_page1

    override fun init() {

    }
}