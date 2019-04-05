package ar.com.wolox.android.example.ui.viewpagerMotion.page2

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class Page2Fragment @Inject constructor():  WolmoFragment<Page2Presenter>(), IPage2View {

    override fun layout(): Int = R.layout.fragment_page2

    override fun init() {

    }


}