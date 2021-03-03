package com.example.loginmain

import com.google.gson.annotations.SerializedName
import retrofit2.http.Headers

class CommentsResponse {
    @SerializedName("comments")
    var comments = ArrayList<Comment>()
}