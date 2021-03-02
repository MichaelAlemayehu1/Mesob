package com.example.loginmain

import com.google.gson.annotations.SerializedName

class UsersResponse {
    @SerializedName("users")
    val users = ArrayList<User>()
}