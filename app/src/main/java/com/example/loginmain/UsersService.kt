package com.example.loginmain

import retrofit2.Call
import retrofit2.http.GET

interface UsersService {
    @GET("b/603e62f30866664b10872790/1")
    fun getUsersList() : Call<UsersResponse>
//    https://api.jsonbin.io/b/603e62f30866664b10872790/1
}