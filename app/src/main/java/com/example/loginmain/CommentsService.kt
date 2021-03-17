package com.example.loginmain

import com.google.gson.JsonObject
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PUT

interface CommentsService {
    @GET("b/603e89e681087a6a8b94d2af/1")
    fun getCommentsList() : Call<CommentsResponse>


    @Headers(
        "content-type:application/json",
        "X-Master-Key:%5C%242b%5C%2410%24h6MNsakz1t3jwFmes8P6je9JAAWoJSLQMNKymmFYSlequaYdZvPdK",
        "X-Bin-Versioning:false"
    )
    @PUT("b/603e89e681087a6a8b94d2af")
    fun updateCommentsList(@Body comment: JsonObject) : Call<CommentsResponse>
//    https://api.jsonbin.io/b/603e89e681087a6a8b94d2af
//    "X-Master-Key:\$2b\$10$h6MNsakz1t3jwFmes8P6je9JAAWoJSLQMNKymmFYSlequaYdZvPdK",

}