package com.example.loginmain

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import com.squareup.picasso.Picasso
import me.relex.circleindicator.CircleIndicator


class RestaurantDetailsActivity : AppCompatActivity() {
    private lateinit var slideshowViewPager : ViewPager
    private lateinit var indicator: CircleIndicator
    private lateinit var imageSliderAdapter : ImageSliderAdapter

    //    Links from sql database to be put here
    //--    var images = intArrayOf(R.drawable.in_n_out_door, R.drawable.in_n_out_door_1, R.drawable.in_n_out_door_2, R.drawable.in_n_out_door_3)
    var images = arrayOf("https://drive.google.com/uc?export=download&id=1-ElbGAXXXzX40xUnMgaZQQWelRICPFkp",
        "https://drive.google.com/uc?export=download&id=1TFcCHx7y-oyRK74KHFA_66ZI-naKOJvT",
        "https://drive.google.com/uc?export=download&id=1-ElbGAXXXzX40xUnMgaZQQWelRICPFkp",
        "https://drive.google.com/uc?export=download&id=1TFcCHx7y-oyRK74KHFA_66ZI-naKOJvT")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        getImageLinks()
        loadSlideshow()
        loadImages()
    }

    private fun getImageLinks(){
        // get image links from my sql
        // update var images from here
    }

    private fun loadSlideshow(){
        val intent = intent
        val restaurantId = intent.getStringExtra("restaurantId")
        Log.e("TheRealG", restaurantId as String)

        slideshowViewPager = findViewById<ViewPager>(R.id.slideshowViewPager)
        indicator = findViewById<CircleIndicator>(R.id.circleIndicator)
        imageSliderAdapter = ImageSliderAdapter(this, images)
        slideshowViewPager.adapter = imageSliderAdapter
        indicator.setViewPager(slideshowViewPager)
    }

    private fun loadImages(){
        val gdImage = findViewById<ImageView>(R.id.foodImage)
        val imageLink = "https://drive.google.com/uc?export=download&id=1TFcCHx7y-oyRK74KHFA_66ZI-naKOJvT"
        Picasso.get().load(imageLink).into(gdImage)
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