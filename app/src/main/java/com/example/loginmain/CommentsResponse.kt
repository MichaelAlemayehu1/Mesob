package com.example.loginmain

import com.google.gson.annotations.SerializedName

class CommentsResponse {
    @SerializedName("comments")
    val comments = ArrayList<Comment>()
}