package com.example.loginmain

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import java.net.URL

class RestaurantMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_main)


        val res1 = findViewById<CardView>(R.id.res1)
//        val context =this
        res1.setOnClickListener{
            val i = Intent(this, RestaurantDetailsActivity::class.java)
            startActivity(i)


        }


    }

    fun openRestaurantDetails(view : View){
        val intent = Intent(this, RestaurantDetailsActivity::class.java)
        intent.putExtra("retaurantId", view.id)

    }

}