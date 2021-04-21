package com.example.ejm02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ShowUsersActivity : AppCompatActivity() {

    val context = this
    var db = DataBaseHandler(context)


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_users)
        var Rv=findViewById<RecyclerView>(R.id.Rv_users)

            Rv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            var adapter=DataAdapter(db.readAllData())
            Rv.adapter=adapter


    }
}

