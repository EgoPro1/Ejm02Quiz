package com.example.ejm02

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

/**
 * Created by VickY on 2017-11-28.
 */
val DATABASE_NAME ="MyDB"
val TABLE_NAME="Users"
val COL_NAME = "name"
val COL_PASSWORD = "password"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(256)," +
                COL_PASSWORD + " VARCHAR(256))"

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COL_NAME, user.name)
        cv.put(COL_PASSWORD, user.password)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

    }

    fun readData(user: User): Boolean /*: MutableList<User>*/ {
        val db = this.readableDatabase
        var correcto = false
        val query = "Select " + COL_NAME + "," + COL_PASSWORD + " from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                if (result.getString(result.getColumnIndex(COL_NAME)) == user.name && result.getString(result.getColumnIndex(COL_PASSWORD)) == user.password) {
                    correcto = true
                }
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return correcto
        //  return list
    }
    fun readAllData():ArrayList<User> /*: MutableList<User>*/ {
        var users =ArrayList<User>()

        val db = this.readableDatabase

        val query = "Select " + COL_ID+ ","+COL_NAME + "," + COL_PASSWORD + " from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                Log.d("Adding user", result.getString(result.getColumnIndex(COL_NAME)))
                Log.d("Adding password",result.getString(result.getColumnIndex(COL_NAME)))
                users.add(User(result.getString(result.getColumnIndex(COL_ID)).toInt(),result.getString(result.getColumnIndex(COL_NAME)),result.getString(result.getColumnIndex(COL_PASSWORD))))
            }while (result.moveToNext())
        }
        result.close()
        db.close()
        return users
        //  return list
    }
    fun readCount(): Int /*: MutableList<User>*/ {
        val db = this.readableDatabase
        var count=0
        val query = "Select " + COL_NAME + "," + COL_PASSWORD + " from " + TABLE_NAME
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            count++
        }
        result.close()
        db.close()
        return count
        //  return list
    }
}

