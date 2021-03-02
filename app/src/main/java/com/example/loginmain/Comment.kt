package com.example.loginmain

import com.google.gson.annotations.SerializedName

class Comment {
    @SerializedName("userName")
    var userName = ""
    @SerializedName("comment")
    var comment = ""
}