package com.example.loginmain

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantCommentDetailsActivity : AppCompatActivity() {
    private lateinit var service : CommentsService
    private var commentsJSONObject = ArrayList<Comment>()
    private var comments = ArrayList<Comment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_comment_details)

        var BaseUrl = "https://api.jsonbin.io/"

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(CommentsService::class.java)

        val cBtn = findViewById<Button>(R.id.commentBtn)
        cBtn.setOnClickListener{
            sendComment()
        }

        getComment()
//        displayComment(comments)


    }

    fun getComment(){
        val call = service.getCommentsList()

        call.enqueue(object : Callback<CommentsResponse> {
            override fun onResponse(call: Call<CommentsResponse>, response: Response<CommentsResponse>) {
                if(response.code() === 200){
                    val commentsResponse = response.body()
                    commentsJSONObject = commentsResponse!!.comments
                    if (commentsResponse != null) {
                        comments = commentsResponse.comments

                        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
                        recyclerView.layoutManager = LinearLayoutManager(baseContext)
                        recyclerView.adapter = CommentRecyclerAdapter(commentsResponse.comments, baseContext)
                        recyclerView.visibility = View.VISIBLE

                        for (user in commentsResponse.comments){
                            Log.e("CMNTRSPNS", user.comment)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {
                Log.e("CMNTCLL", "Call failed!")
            }

        })
    }

//    fun displayComment(comments : ArrayList<Comment>){
//        Log.e("SSS", comments!!.first().comment)
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = CommentRecyclerAdapter(comments, this)
//        recyclerView.visibility = View.VISIBLE
//
//    }

    private fun sendComment(){
        val userId = intent.getStringExtra("UserId")
        val commentBox = findViewById<EditText>(R.id.commentEditText)

        val newCommentJSONObject = JSONObject()
        val updatedCommentsArrayList = commentsJSONObject + mapOf("comment" to commentBox.text.toString(), "userName" to userId )
        val updatedCommentsString = Gson().toJson(updatedCommentsArrayList)

        newCommentJSONObject.put("comments", JSONArray(updatedCommentsString))

        // Changing from JSONObject to JsonObject to prevent "nameValuePairs" entry
        val newCommentJsonObject = JsonParser().parse(newCommentJSONObject.toString()).asJsonObject


        val call = service.updateCommentsList(newCommentJsonObject)

        call.enqueue(object : Callback<CommentsResponse> {
            override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {
                Log.e("CMNTUPDT", "Error during upload")
            }

            override fun onResponse(call: Call<CommentsResponse>, response: Response<CommentsResponse>) {
                if (response.code() == 200){
                    Log.e("CMNTUPDT", response.body().toString())
                    Log.e("CMNTUPDT", "Comment sent to cloud")
                }
                else{
                    Log.e("CMNTUPDT", response.code().toString())
                }
            }

        })
    }
}