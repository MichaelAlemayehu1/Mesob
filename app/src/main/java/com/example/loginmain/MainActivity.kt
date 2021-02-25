package com.example.loginmain

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Login = findViewById<CardView>(R.id.cardView)
//        val text = findViewById<TextView>(R.id.editTextTextPersonName3)

        Login.setOnClickListener{
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
//        val dataBase = findViewById<TextView>(R.id.data_base)

//        dataBase.setOnClickListener{
//            val i = Intent(this, DataBase::class.java)
//            startActivity(i)
//        }
    }







}