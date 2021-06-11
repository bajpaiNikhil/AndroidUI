package com.example.androidui

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity() {
    val isLoginDone = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

//        submitB.setOnClickListener {
//            Log.d("AUthActivity " , "${(it as Button).text}Clicked!")
//        }
    }

    override fun onResume() {
        super.onResume()
            //cancel notification
        val nmangeer = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        nmangeer.cancel(1)

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


    override fun onBackPressed() {
        if(!isLoginDone){
            sendNOtification()
        }
        super.onBackPressed()
    }

    private fun sendNOtification() {

        //!. get reference of notifiacation manager
        val nManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        //2. create notification

        val builder : Notification.Builder

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channel = NotificationChannel("test" , "Android Ui",NotificationManager.IMPORTANCE_DEFAULT)

            nManager.createNotificationChannel(channel)

            builder = Notification.Builder(this , "test" )
        }else{
            builder = Notification.Builder(this)
        }


        //icon,title,action,descrption

        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.setContentTitle("Authentication")
        builder.setContentText("complete your sign-in")




        val i  = Intent(this , AuthActivity::class.java)
        val pi = PendingIntent.getActivity(this,0 , i , 0)
        builder.setContentIntent(pi)

        val myNotification = builder.build()

        myNotification.flags = Notification.FLAG_NO_CLEAR

        //3. show the notification


        nManager.notify(1,myNotification)

        Log.d("Auth Activity ", "This is the Way! . ")


    }
}
















