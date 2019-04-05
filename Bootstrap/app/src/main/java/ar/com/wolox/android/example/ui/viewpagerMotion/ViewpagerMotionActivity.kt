package ar.com.wolox.android.example.ui.viewpagerMotion

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class ViewpagerMotionActivity : WolmoActivity() {
    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, ViewpagerMotionFragment())
    }
}
