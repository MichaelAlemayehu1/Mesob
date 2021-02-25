package com.example.loginmain

import android.content.ContentValues
import android.content.Context
import android.content.LocusId
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DataBaseName = "Res_DB"
val TableName = "Restaurants"
val col_ID = "ID"
val col_Res = "Res_Name"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DataBaseName,null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
       val createTable = "CREATE TABLE " + TableName + " (" +
               col_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
               col_Res + " INTEGER)";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(res:Restaurant){
        val db = this.writableDatabase
        var cv = ContentValues()
//        cv.put(col_ID,res.id)
        cv.put(col_Res, res.restaurantName)
       var result =  db.insert(TableName, null,cv)

        if(result == (-1).toLong())
            Toast.makeText(context , "failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
    }

    fun readData(): MutableList<Restaurant>{
        var list : MutableList<Restaurant> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TableName"

        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                var res = Restaurant()
                res.id = result.getString(result.getColumnIndex(col_ID)).toInt()
                res.restaurantName = result.getString(result.getColumnIndex(col_Res))

                list.add(res)
            }while(result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun updateData(){

        val db = this.writableDatabase
        val query = "Select * from $TableName"

        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                var cv = ContentValues()
                cv.put(col_Res,result.getString(result.getColumnIndex(col_Res))+"car")
              db.update(TableName, cv, col_ID+"=?", arrayOf(result.getString(result.getColumnIndex(
                  col_ID))))

            }while(result.moveToNext())
        }

        result.close()
        db.close()

    }

    fun deleteData(){
        val db = this.writableDatabase


        db.delete(TableName, col_ID+"=?", arrayOf(16.toString()))
//        db.delete(TableName, null, null) TO DELETE ALL
        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '$TableName'");
        db.close()

    }
}