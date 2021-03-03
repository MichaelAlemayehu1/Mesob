package com.example.loginmain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentRecyclerAdapter(private val dataset: ArrayList<Comment>?) :
    RecyclerView.Adapter<CommentRecyclerAdapter.ViewHolder> (){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val usernameText : TextView = view.findViewById(R.id.userName)
        val commentText : TextView = view.findViewById(R.id.commentText)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.comment_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.usernameText.text = dataset?.get(position)!!.userName
        viewHolder.commentText.text = dataset?.get(position)!!.comment
    }

    override fun getItemCount(): Int = dataset?.size!!
}