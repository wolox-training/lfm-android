package ar.com.wolox.android.example.ui.home


import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsService
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback
import okhttp3.ResponseBody
import javax.inject.Inject

class NewsPresenter @Inject constructor() : BasePresenter<INewsView>() {
    //class NewsData(var newsHeader:String, var newsDescription:String,var time:String, var image:Uri)
    //private var myDataSet= arrayListOf<NewsPresenter.NewsData>()
    lateinit var mRetrofitServices: RetrofitServices
    fun getNnumberOfNews( N:Int){
        mRetrofitServices.getService(NewsService::class.java).getNewsById(N).enqueue(object : NetworkCallback<List<News>>() {
            override fun onResponseFailed(p0: ResponseBody?, p1: Int) {
                view.setErrorCode(2)
            }

            override fun onResponseSuccessful(newsList: List<News>?) {
                if (newsList!!.isNotEmpty()){
                view.updateDataSet(newsList,N)
                }
                else{
                    view.setErrorCode(1)
                }

            }

            override fun onCallFailure(p0: Throwable) {
                view.setErrorCode(3)
            }


        })
    }

}
