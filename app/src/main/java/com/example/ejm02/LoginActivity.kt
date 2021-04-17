package com.example.ejm02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val context = this
        var db = DataBaseHandler(context)
        var btI=findViewById<Button>(R.id.btIngresar)
        btI.setOnClickListener{ if(editTextTextPersonName.text.toString().isEmpty()||editTextTextPassword.text.toString().isEmpty())
        {
            Toast.makeText(this,"Fill Edittext",Toast.LENGTH_SHORT).show()
        }else {
            var user = User(editTextTextPersonName.text.toString(), editTextTextPassword.text.toString())

            var data = db.readData(user)
            if (data == true) {
                Toast.makeText(this, "Logged", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Incorrect Data", Toast.LENGTH_SHORT).show()
            }
        }}

    }

    fun Registrar(view: View){
        val intent= Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
}
