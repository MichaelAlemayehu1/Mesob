package com.example.loginmain

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetUsersWorker (appContext: Context, workerParams: WorkerParameters):
Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val users = loadUsers().toString()
        val outputDataUsers = workDataOf("users" to users)
        return Result.success(outputDataUsers)
    }

    fun loadUsers() : ArrayList<User>?{
        var users : ArrayList<User> = ArrayList()

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

        return users
    }

}