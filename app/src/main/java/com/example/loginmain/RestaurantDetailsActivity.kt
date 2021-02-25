package com.example.loginmain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import me.relex.circleindicator.CircleIndicator


class RestaurantDetailsActivity : AppCompatActivity() {
    private lateinit var slideshowViewPager : ViewPager
    private lateinit var indicator: CircleIndicator
    var images = intArrayOf(R.drawable.in_n_out_door, R.drawable.in_n_out_door_1, R.drawable.in_n_out_door_2, R.drawable.in_n_out_door_3)
    private lateinit var imageSliderAdapter : ImageSliderAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        slideshowViewPager = findViewById<ViewPager>(R.id.slideshowViewPager)
        indicator = findViewById<CircleIndicator>(R.id.circleIndicator)
        imageSliderAdapter = ImageSliderAdapter(this, images)
        slideshowViewPager.adapter = imageSliderAdapter
        indicator.setViewPager(slideshowViewPager)
    }

    fun openMenuDetailed(view: View){
        val intent = Intent(this, RestaurantMenuDetailsActivity::class.java)
        startActivity(intent)
    }

    fun openCommentsDetailed(view: View){
        val intent = Intent(this, RestaurantCommentDetailsActivity::class.java)
        startActivity(intent)
    }

//    flatten out on touch
//    fun startFoodDetails(view : View){
//        view.elevation = 4.0F
//        Run.after(20){
//            view.elevation = 16.0F
//        }
//    }
}