package ar.com.wolox.android.example.model

data class News (val id:Int ,val userId:Int,val createdAt:String,val title:String, val picture:String, val text:String , val like:Boolean)