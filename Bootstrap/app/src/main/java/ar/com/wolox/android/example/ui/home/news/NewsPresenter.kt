package ar.com.wolox.android.example.ui.home


import android.net.Uri
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor() : BasePresenter<INewsView>() {
    class NewsData(var newsHeader:String, var newsDescription:String,var time:String, var image:Uri)

    fun refreshNews(){

    }

}
