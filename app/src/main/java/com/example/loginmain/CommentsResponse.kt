package com.example.loginmain

import com.google.gson.annotations.SerializedName

class CommentsResponse {
    @SerializedName("comments")
    var comments = ArrayList<Comment>()
}