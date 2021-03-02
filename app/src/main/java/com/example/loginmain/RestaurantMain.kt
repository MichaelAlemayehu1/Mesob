package com.example.loginmain

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.cardview.widget.CardView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class RestaurantMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_main)

        var BaseUrl = "https://api.jsonbin.io/"

        val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(UsersService::class.java)
        val call = service.getUsersList()

        call.enqueue(object : Callback<UsersResponse>{
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if(response.code() === 200){
                    val usersResponse = response.body()
                    if (usersResponse != null) {
                        for (user in usersResponse.users){
                            Log.e("USRRSPNS", user.toString())
                        }
                    }
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("USRCLL", "Call failed!")
            }

        })
    }

    fun openRestaurantDetails(view : View){
        val intent = Intent(this, RestaurantDetailsActivity::class.java)
        intent.putExtra("restaurantId", "view.id")
        Log.e("TheRealG", view.id.toString()?:"null")

        startActivity(intent)
    }

}