package com.example.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(){
    val isRegistered = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton = findViewById<Button>(R.id.register)
        registerButton.setOnClickListener {
            val i = Intent(this , activity_register::class.java)
            startActivity(i)
        }

        val loginButton = findViewById<Button>(R.id.login)
        loginButton.setOnClickListener {
            val i = Intent(this,AuthActivity::class.java)
            startActivity(i)
        }


    }

    val MENU_LOGIN = 1
    val MENU_EXIT  = 2
    val REGISTER   = 3


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menu?.add(0,MENU_LOGIN,0,"SIGH IN !")
        menu?.add(0,MENU_EXIT , 0 ,"EXIT .")
        menu?.add(Menu.NONE , REGISTER,Menu.NONE , "REGISTER .")


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("MAainActivity " ," ${item.title} option is seelcted")
        val id  = item.itemId
        when (id){
            MENU_LOGIN ->{
                val i = Intent(this , AuthActivity::class.java)
                startActivity(i)
                return true

            }
            MENU_EXIT ->{
                finish()
                return true
            }
            REGISTER -> {
                val i = Intent(this,activity_register::class.java)
                startActivity(i)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}