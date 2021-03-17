//.package com.example.loginmain
//
//import android.app.ProgressDialog
//import android.content.Context
//import android.os.AsyncTask
//import android.os.Parcel
//import android.os.Parcelable
//import android.widget.Toast
//import androidx.loader.content.AsyncTaskLoader
//import androidx.recyclerview.widget.AsyncListDiffer
//import androidx.recyclerview.widget.RecyclerView
//import org.json.JSONArray
//import org.json.JSONException
//import org.json.JSONObject
//
//
//class AsyncCallAdapter(c: Context, jsonData: String, rv: RecyclerView) : AsyncTaskLoader, Parcelable {
//
//    constructor(parcel: Parcel) : this(
//            TODO("c"),
//            TODO("jsonData"),
//            TODO("rv")) {
//        jsonData = parcel.readString()
//    }
//
//    fun onPreExecute() {
//        super.onPreExecute()
//        pd = ProgressDialog(c)
//        pd!!.setTitle("Parse JSON")
//        pd!!.setMessage("Parsing...Please wait")
//        pd!!.show()
//    }
//
//    protected override fun doInBackground(vararg voids: Void): Boolean {
//        return parse()
//    }
//
//    override fun onPostExecute(isParsed: Boolean) {
//        super.onPostExecute(isParsed)
//        pd!!.dismiss()
//        if (isParsed) {
//            //BIND
//            val adapter = MyAdapter(c, users)
//            rv.adapter = adapter
//        } else {
//            Toast.makeText(c, "Unable To Parse,Check Your Log output", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun parse(): Boolean {
//        return try {
//            val ja = JSONArray(jsonData)
//            var jo: JSONObject
//            users.clear()
//            for (i in 0 until ja.length()) {
//                jo = ja.getJSONObject(i)
//                val name = jo.getString("name")
//                users.add(name)
//            }
//            true
//        } catch (e: JSONException) {
//            e.printStackTrace()
//            false
//        }
//    }
//
//    init {
//        this.c = c
//        this.jsonData = jsonData
//        this.rv = rv
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(jsonData)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<AsyncCallAdapter> {
//        override fun createFromParcel(parcel: Parcel): AsyncCallAdapter {
//            return AsyncCallAdapter(parcel)
//        }
//
//        override fun newArray(size: Int): Array<AsyncCallAdapter?> {
//            return arrayOfNulls(size)
//        }
//    }
//}