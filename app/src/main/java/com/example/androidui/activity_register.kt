package com.example.androidui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class activity_register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        enterB.setOnClickListener {
            val Email = registerEmail.text.toString()
            val phoneNumber = registerPhoneNo.text.toString()

            val i = Intent(this , ShowActivity::class.java)
            i.putExtra(ShowActivity.EmailID,Email)
            i.putExtra(ShowActivity.PhoneNO,phoneNumber)
            startActivity(i)
        }
    }

    fun enterbutton(view: View) {

        val userId = registerEmail.text.toString()

        val passWord = registerPassW.text.toString()

        val confirmPassword = registerCPassW.text.toString()

        val phoneNumber = registerPhoneNo.text.toString()

        if ( (confirmPassword == passWord) && (phoneNumber.length == 10) ){
            Toast.makeText(this , "your email is $userId" , Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this ,"Do it again !." , Toast.LENGTH_LONG).show()
        }
    }

    fun cancelButtonPress(view: View) {
        finish()
    }

}

