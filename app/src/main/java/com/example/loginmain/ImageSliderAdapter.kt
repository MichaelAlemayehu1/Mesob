package com.example.loginmain

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso

class ImageSliderAdapter(var context: Context, var images: Array<String>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun getCount(): Int {
        return  images.size
    }

    override fun instantiateItem( container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.restaurant_image_fragment, container, false)
        val imageView = view.findViewById<ImageView>(R.id.restaurantImage)
        Picasso.get()
                .load(images[position])
                .into(imageView)
        container.addView(view, position - 1)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

}