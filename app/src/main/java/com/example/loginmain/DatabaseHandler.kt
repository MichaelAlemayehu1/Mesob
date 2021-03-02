package com.example.loginmain

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, "resDB",null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Rest(RESLINK TEXT PRIMARY KEY, RESNAME TEXT)")
        db?.execSQL("INSERT INTO Rest(RESLINK,RESNAME) VALUES('https://drive.google.com/uc?export=download&id=1-ElbGAXXXzX40xUnMgaZQQWelRICPFkp', 'NITSUH')")
        db?.execSQL("INSERT INTO Rest(RESLINK,RESNAME) VALUES('https://drive.google.com/uc?export=download&id=1TFcCHx7y-oyRK74KHFA_66ZI-naKOJvT', 'NITSUH')")
        db?.execSQL("INSERT INTO Rest(RESLINK,RESNAME) VALUES('https://drive.google.com/uc?export=download&id=15jicKrXSO7XIvwU9j93wM9Nk-GbmILCz', 'NITSUH')")
        db?.execSQL("INSERT INTO Rest(RESLINK,RESNAME) VALUES('https://drive.google.com/uc?export=download&id=1x9FSWBcORAihmoHmx2voPD3JF-iyGIQL', 'NITSUH')")
//        db?.execSQL("INSERT INTO Rest(RESLINK,RESNAME) VALUES('LINK5', 'NITSUH')")
//        db?.execSQL("INSERT INTO Rest(RESLINK, RESNAME) VALUES('LINK6', 'NITSUH') " )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//
    }
}