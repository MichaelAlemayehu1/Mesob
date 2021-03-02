package com.example.loginmain

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var BaseUrl = "https://api.jsonbin.io/"

        val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(UsersService::class.java)
        val call = service.getUsersList()

        call.enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if(response.code() === 200){
                    val usersResponse = response.body()
                    if (usersResponse != null) {
                        for (user in usersResponse.users){
                            Log.e("USRRSPNS", user.userName)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("USRCLL", "Call failed!")
            }

        })


        val card = findViewById<CardView>(R.id.cardView)
//        val text = findViewById<TextView>(R.id.editTextTextPersonName3)

        card.setOnClickListener{
            val i = Intent(this, RestaurantMain::class.java)
            startActivity(i)

            val toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT)
            toast.show()
        }
        val card2 = findViewById<CardView>(R.id.cardView2)
//        val text = findViewById<TextView>(R.id.editTextTextPersonName3)

        card2.setOnClickListener{
            val i = Intent(this, RegisterPage::class.java)
            startActivity(i)

        }
    }




}