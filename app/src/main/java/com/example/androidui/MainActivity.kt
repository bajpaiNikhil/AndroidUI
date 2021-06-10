package com.example.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
}