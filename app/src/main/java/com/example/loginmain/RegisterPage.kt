package com.example.loginmain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        val card = findViewById<Button>(R.id.RegisterPage)
//        val text = findViewById<TextView>(R.id.editTextTextPersonName3)

        card.setOnClickListener{
            val i = Intent(this, Home::class.java)
            startActivity(i)

            val toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT)
            toast.show()
        }
        val card2 = findViewById<Button>(R.id.LoginReg)
//        val text = findViewById<TextView>(R.id.editTextTextPersonName3)

        card2.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)


        }
    }
}