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
import androidx.viewpager.widget.ViewPager
import me.relex.circleindicator.CircleIndicator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class RestaurantMain : AppCompatActivity() {
    private lateinit var slideshowViewPager : ViewPager
    private lateinit var imageSliderAdapter : ImageSliderAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_main)

        loadSlideshow()
    }

    private fun loadSlideshow(){
        var images = arrayOf("https://drive.google.com/uc?export=download&id=1-ElbGAXXXzX40xUnMgaZQQWelRICPFkp",
                "https://drive.google.com/uc?export=download&id=1TFcCHx7y-oyRK74KHFA_66ZI-naKOJvT",
                "https://drive.google.com/uc?export=download&id=1-ElbGAXXXzX40xUnMgaZQQWelRICPFkp",
                "https://drive.google.com/uc?export=download&id=1TFcCHx7y-oyRK74KHFA_66ZI-naKOJvT")

        slideshowViewPager = findViewById<ViewPager>(R.id.restaurantSlideshow)
        imageSliderAdapter = ImageSliderAdapter(this, images)
        slideshowViewPager.adapter = imageSliderAdapter
    }

    fun openRestaurantDetails(view : View){
        val userId = getIntent().getStringExtra("UserId")
        val intent = Intent(this, RestaurantDetailsActivity::class.java)
        intent.putExtra("restaurantId",view.contentDescription)
        intent.putExtra("UserId", userId)

        startActivity(intent)
    }

}