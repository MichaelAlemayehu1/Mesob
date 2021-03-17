package com.example.loginmain

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var users : ArrayList<User>

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
                    users = usersResponse!!.users


                    for (user in usersResponse.users){
                        Log.e("USRRSPNS", user.userName)
                    }
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("USRCLL", "Call failed!")
            }

        })



        val card = findViewById<CardView>(R.id.cardView)
//        val text = findViewById<TextView>(R.id.editTextTextPersonName3)

//        card.setOnClickListener{
//            val i = Intent(this, RestaurantMain::class.java)
//            startActivity(i)
//
//            val toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT)
//            toast.show()
//        }
        val card2 = findViewById<CardView>(R.id.cardView2)
//        val text = findViewById<TextView>(R.id.editTextTextPersonName3)

        card2.setOnClickListener{
            val i = Intent(this, RestaurantMain::class.java)
            startActivity(i)

        }
    }


    fun checkLogin(view: View){
        val username = findViewById<EditText>(R.id.editTextTextPersonName3).text.toString()
        val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

        try {

            for (user in users){
                if(user.userName == username && user.password == password){
                    val intent = Intent(this, RestaurantMain::class.java)
                    intent.putExtra("UserId", username)
                    startActivity(intent)
                    return
                }
                else{
                    Toast.makeText(this,"Invalid username or password!", Toast.LENGTH_SHORT).show()
                }
            }
        }catch (e : IllegalStateException){
            Toast.makeText(this,"Check network!", Toast.LENGTH_SHORT).show()
        }
    }


}