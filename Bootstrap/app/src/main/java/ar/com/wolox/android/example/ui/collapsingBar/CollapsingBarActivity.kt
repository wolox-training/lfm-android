package ar.com.wolox.android.example.ui.collapsingBar

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class CollapsingBarActivity : WolmoActivity() {
    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, CollapsingBarFragment())
    }
}