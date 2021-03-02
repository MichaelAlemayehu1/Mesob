package com.example.loginmain

import retrofit2.Call
import retrofit2.http.GET

interface UsersService {
    @GET("b/603e856b0866664b10874484")
    fun getUsersList() : Call<UsersResponse>
//    https://api.jsonbin.io/b/603e856b0866664b10874484
}