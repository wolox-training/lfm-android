package ar.com.wolox.android.example.ui.home
import ar.com.wolox.android.example.model.News

interface INewsView {

     fun setErrorCode(i: Int)

     fun updateXNewNews(list:List<News>, X:Int)

     fun addXOlderNews(list:List<News>, X:Int)
}