package ar.com.wolox.android.example.ui.newsDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class NewsDetailActivity : WolmoActivity() {

    companion object {
        fun startNewsDetailActivity(context:Context,bundle: Bundle){
            var starter=Intent(context, NewsDetailActivity::class.java)
            starter.putExtras(bundle)
            context.startActivity(starter)
        }
    }
    override fun layout(): Int = R.layout.activity_base

    override fun init() {
        replaceFragment(R.id.vActivityBaseContent, NewsDetailFragment.instance(this.intent.extras))
    }

}