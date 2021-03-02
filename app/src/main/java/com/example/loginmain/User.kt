package com.example.loginmain

import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("userName")
    var userName = ""
    @SerializedName("password")
    var password = ""
}