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
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.ViewPager
import com.squareup.picasso.Picasso
import me.relex.circleindicator.CircleIndicator
import java.util.prefs.BackingStoreException


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

        val intent = intent
        val restaurantId = intent.getStringExtra("restaurantId")
        Log.e("TheRealG", restaurantId as String)
        personaliseChoice(restaurantId)
        getImageLinks()
        loadSlideshow()
        loadImages()
    }
    fun Back(view: View){
        val i = Intent(this,RestaurantMain::class.java)
    }

    private fun getImageLinks(){
        // get image links from my sql
        // update var images from here
    }

    private fun loadSlideshow(){


        slideshowViewPager = findViewById<ViewPager>(R.id.slideshowViewPager)
        indicator = findViewById<CircleIndicator>(R.id.circleIndicator)
        imageSliderAdapter = ImageSliderAdapter(this, images)
        slideshowViewPager.adapter = imageSliderAdapter
        indicator.setViewPager(slideshowViewPager)
    }
    fun personaliseChoice(restaurantId:String){
        val choice = findViewById<TextView>(R.id.restaurantName)
        choice.text = restaurantId
    }

    private fun loadImages(){
        var help = DatabaseHandler(applicationContext)
//open db to be read
        var db = help.readableDatabase
        var rs = db.rawQuery("SELECT min(RESLINK) FROM  Rest WHERE RESNAME = 'NITSUH'",null)

        val gdImage = findViewById<ImageView>(R.id.foodImage)
        rs.moveToNext()

        val imageLink = rs.getString(0)
        Log.e("this",rs.getString(0))
//        val imageLink = "https://drive.google.com/uc?export=download&id=1TFcCHx7y-oyRK74KHFA_66ZI-naKOJvT"
        Picasso.get().load(imageLink).into(gdImage)
    }


    fun openMenuDetailed(view: View){
        var userId = getIntent().getStringExtra("UserId")
        val intent = Intent(this, RestaurantMenuDetailsActivity::class.java)
        intent.putExtra("UserId", userId)
        startActivity(intent)
}

    fun openCommentsDetailed(view: View){
        var userId = getIntent().getStringExtra("UserId")
        val intent = Intent(this, RestaurantCommentDetailsActivity::class.java)
        intent.putExtra("UserId", userId)
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