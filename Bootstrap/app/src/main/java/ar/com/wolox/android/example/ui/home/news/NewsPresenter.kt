package ar.com.wolox.android.example.ui.home


import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.presenter.BasePresenter

class NewsPresenter () : BasePresenter<News>() {

    val imagen= "https://cdn-images-1.medium.com/fit/c/100/100/1*RIlH4dGIVDccLZ0JTH3lhg.png"
    fun initialLoad(myDataSet: MutableList<News>):List<News>{
        for (i in 0..100) {
            myDataSet.add(News(i, 2, "2016-07-18T14:00:29.985Z", "Titulo $i", imagen, "descripcion...", true))
        }
        return myDataSet.subList(0,10)
    }
    fun loadNmoreNews(n: Int, lastItemReturned:Int,myDataSet: MutableList<News>):MutableList<News>{
        val list=myDataSet.subList(lastItemReturned,lastItemReturned+n)
        return list
    }

    fun updateNews(n:Int,myDataSet: MutableList<News>):MutableList<News>{
        val list: MutableList<News> = ArrayList()

        for (i in 0..n) {
            list.add(News(i, 2, "2016-07-18T14:00:29.985Z", "Titulo $i", imagen, "descripcion...", true))
        }
        list.addAll(myDataSet)
        return list
    }
    //private var myDataSet= arrayListOf<NewsPresenter.NewsData>()
   /* lateinit var mRetrofitServices: RetrofitServices
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
*/
}
