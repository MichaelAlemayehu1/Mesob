package com.example.loginmain

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT

interface CommentsService {
    @GET("b/603e89e681087a6a8b94d2af")
    fun getCommentsList() : Call<CommentsResponse>
    @Headers("content-type:application/json")
    @PUT("b/603e89e681087a6a8b94d2af")
    fun updateCommentsList(@Body comment: CommentsResponse) : Call<CommentsResponse>
//    https://api.jsonbin.io/b/603e89e681087a6a8b94d2af
}