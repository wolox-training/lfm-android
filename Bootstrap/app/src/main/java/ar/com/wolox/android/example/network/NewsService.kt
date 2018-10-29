package ar.com.wolox.android.example.network

import ar.com.wolox.android.example.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/news")
    fun getNewsById(@Query("id") id:Int): Call<List<News>>

    @GET("/news")
    fun getAllNews(): Call<List<News>>

    @GET("/news")
    fun getNnumberOfNews(@Query() N:Int): Call<List<News>>
    //TODO query to bring the Nth newer news since the last one

}