package com.example.loginmain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantCommentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_comment_details)

        var BaseUrl = "https://api.jsonbin.io/"

        val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(CommentsService::class.java)
        val call = service.getCommentsList()

        call.enqueue(object : Callback<CommentsResponse> {
            override fun onResponse(call: Call<CommentsResponse>, response: Response<CommentsResponse>) {
                if(response.code() === 200){
                    val commentsResponse = response.body()
                    if (commentsResponse != null) {
                        for (user in commentsResponse.comments){
                            Log.e("CMNTRSPNS", user.comment)
//                            Log.e("CMNTRSPNS", "hey")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {
                Log.e("CMNTCLL", "Call failed!")
            }

        })

    }

    fun sendComment(view: View){
        val textBox = findViewById<EditText>(R.id.commentEditText)
    }
}