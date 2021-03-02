package com.example.loginmain

import retrofit2.Call
import retrofit2.http.GET

interface CommentsService {
    @GET("b/603e89e681087a6a8b94d2af")
    fun getCommentsList() : Call<CommentsResponse>
//    https://api.jsonbin.io/b/603e89e681087a6a8b94d2af
}