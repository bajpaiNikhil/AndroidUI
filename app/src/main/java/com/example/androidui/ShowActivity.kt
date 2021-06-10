package com.example.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity() {

    companion object{

        const val EmailID = "Email"
        const val PhoneNO = "PhoneNO."

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val email = intent.getStringExtra(EmailID)
        val phoneNumber = intent.getStringExtra(PhoneNO)

        showEmail.text = "email is : "+ email
        showPhnumber.text = "Your phone Number : " + phoneNumber

    }

    fun showExit(view: View) {
        //finish()
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }
}