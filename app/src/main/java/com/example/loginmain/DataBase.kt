package com.example.loginmain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class DataBase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)

        val context = this

        var resName = findViewById<EditText>(R.id.Resname)
        var resultDB = findViewById<TextView>(R.id.DBresult)
        var db = DatabaseHandler(context)
        var btnAdd = findViewById<Button>(R.id.addData)
        var btnRead = findViewById<Button>(R.id.readData)
        var btnDel = findViewById<Button>(R.id.Delete)
        var update = findViewById<Button>(R.id.updateData)
        btnAdd.setOnClickListener{
            if(resName.text.toString().isNotEmpty()){
            var res = Restaurant(resName.text.toString())
            var db = DatabaseHandler(context)
            db.insertData(res)
            btnRead.performClick()

        }
            else{
                Toast.makeText(context, "Fill out Field", Toast.LENGTH_SHORT).show()
            }
    }

        btnRead.setOnClickListener{
            var data = db.readData()
            resultDB.text = ""

            for (i in 0..(data.size-1)){
                resultDB.append(data[i].id.toString() + " " + data[i].restaurantName + "\n")
            }
        }

        update.setOnClickListener{
            db.updateData()
            btnRead.performClick()
        }

        btnDel.setOnClickListener{
            db.deleteData()
            btnRead.performClick()
        }

//    var res = Restaurant(1,"Nitsu")
//    var db = DatabaseHandler(context)
//    db.insertData(res)
}
}