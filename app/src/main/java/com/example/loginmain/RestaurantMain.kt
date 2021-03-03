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
    }

    fun openRestaurantDetails(view : View){
        val userId = getIntent().getStringExtra("UserId")
        val intent = Intent(this, RestaurantDetailsActivity::class.java)
        intent.putExtra("restaurantId",view.contentDescription)
        intent.putExtra("UserId", userId)

        startActivity(intent)
    }

}