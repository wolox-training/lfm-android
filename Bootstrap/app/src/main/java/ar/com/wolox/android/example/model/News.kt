package ar.com.wolox.android.example.model

import java.io.Serializable

data class News (val id: Int, val userId:Int, val createdAt:String, val title:String, val picture:String, val text:String, var like:Boolean):Serializable