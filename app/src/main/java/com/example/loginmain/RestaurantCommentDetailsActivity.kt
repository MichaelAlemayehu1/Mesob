package com.example.loginmain

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantCommentDetailsActivity : AppCompatActivity() {
    private lateinit var service : CommentsService
    private var commentsJSONObject = ArrayList<Comment>()

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
    }

    fun getComment(){
        val call = service.getCommentsList()

        call.enqueue(object : Callback<CommentsResponse> {
            override fun onResponse(call: Call<CommentsResponse>, response: Response<CommentsResponse>) {
                if(response.code() === 200){
                    val commentsResponse = response.body()
                    commentsJSONObject = commentsResponse!!.comments
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

    private fun sendComment(){
        val commentBox = findViewById<EditText>(R.id.commentEditText)
        var comment = Comment()

//        val key = "$2b$10\$RqpIOOPAoRlRnH4oUAtsne7MxLTz3oIci39NcIIIKlv.lHivOY/oe"
//        val binId = "603e89e681087a6a8b94d2af"
//        Ksonbin.init(key)


//        comment.comment = commentBox.text.toString()
//        comment.userName = "Lola"
//        commentsJSONObject.add(comment)

        var userId = getIntent().getStringExtra("UserId")
        var jsonObject = JSONObject( Gson().toJson(commentsJSONObject + mapOf("comment" to commentBox.text, "userName" to intent.getStringExtra("userId") )) )
//        val updatedBin: BinUpdate<JSONObject> = Ksonbin.bin.update(binId, jsonObject, true, key)
//        println("update bin ${binId}: $updatedBin")

        var commentsResponse= CommentsResponse()
        commentsResponse.comments = commentsJSONObject



        val call = service.updateCommentsList(jsonObject)

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