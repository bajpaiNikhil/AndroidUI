package com.example.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

//        submitB.setOnClickListener {
//            Log.d("AUthActivity " , "${(it as Button).text}Clicked!")
//        }
    }



    fun buttonClicked(view: View) {
        Log.d("AUTHACTIVITY" ,"${(view as Button).text} Cliced")
    }
    fun submitButton(view: View) {
        Log.d("AuthActivity","submitClicked")

        val userId = useridE.text.toString()
        val password = passE.text.toString()

        if (userId.length > 0 && password.length > 0){
            Toast.makeText(this , "you entered $userId , $password" , Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(this , "you have to enter all the fields " , Toast.LENGTH_LONG).show()
        }
    }
}