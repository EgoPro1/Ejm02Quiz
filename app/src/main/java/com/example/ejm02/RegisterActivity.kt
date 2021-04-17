package com.example.ejm02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val context = this
        var db = DataBaseHandler(context)
        var btC=findViewById<Button>(R.id.btConfirmar)
        btC.setOnClickListener{
            if (etUser.text.toString().length > 0 &&
                    etPassword.text.toString().length > 0&& etPassword.text.toString()== etCPassword.text.toString()) {
                var user = User(etUser.text.toString(),etPassword.text.toString())
                db.insertData(user)
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(context,"Please Fill All Data's and Confirm well the password",Toast.LENGTH_SHORT).show()
            }
        }

        }






}

