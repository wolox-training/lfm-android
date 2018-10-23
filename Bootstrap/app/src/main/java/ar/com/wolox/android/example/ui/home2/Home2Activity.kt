package ar.com.wolox.android.example.ui.home2

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class Home2Activity : WolmoActivity() {

    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, Home2Fragment())
    }
}