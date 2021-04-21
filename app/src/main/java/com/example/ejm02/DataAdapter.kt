package com.example.ejm02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(val users: ArrayList<User>) : RecyclerView.Adapter<DataAdapter.ViewHolderData>()
{



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {

        var view=LayoutInflater.from(parent.context).inflate(R.layout.useritem_list,null,false)

        return ViewHolderData(view)
    }

    override fun getItemCount(): Int {
       return users.size
    }

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        holder.assigndata(users[position])
    }


    class ViewHolderData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun assigndata(user: User) {
            dato.text=user.name
        }


        var dato=itemView.findViewById<TextView>(R.id.tv_useritem)


    }


}