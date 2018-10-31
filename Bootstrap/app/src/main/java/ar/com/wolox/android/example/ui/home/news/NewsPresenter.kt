package ar.com.wolox.android.example.ui.home


import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor () : BasePresenter<News>() {
    private lateinit var fetchedNews:MutableList<News>
    private val imagen= "https://cdn-images-1.medium.com/fit/c/100/100/1*RIlH4dGIVDccLZ0JTH3lhg.png"
    fun initialLoad():List<News>{
        fetchedNews= mutableListOf()
        for (i in 0..20) {
            fetchedNews.add(News(i, 2, "2016-07-18T14:00:29.985Z", "Titulo$i", imagen, "descripcion...", true))
        }
        return fetchedNews.toList().subList(0,15)
    }
    fun loadNmoreNews(n: Int):List<News>{
        for (i in 0..n) {
            fetchedNews.add(News(i, 2, "2016-07-18T14:00:29.985Z", "Titulo ${fetchedNews.lastIndex+1}", imagen, "descripcion...", true))
        }
        return fetchedNews.toList()
    }

    fun updateNews(n:Int):List<News>{
        val list= mutableListOf<News>()

        for (i in 0..n) {
            list.add(News(i, 2, "2016-07-18T14:00:29.985Z", "NEW **** Titulo $i", imagen, "descripcion...", true))
        }
        list.addAll(fetchedNews)
        fetchedNews=list
        return list.toList()
    }
}
