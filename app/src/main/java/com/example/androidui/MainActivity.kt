package com.example.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
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

        val contextMenuButton = findViewById<Button>(R.id.demoB)
        registerForContextMenu(contextMenuButton)
    }

    val MENU_LOGIN = 1
    val MENU_EXIT  = 2
    val REGISTER   = 3


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val item1 = menu?.add(0,MENU_LOGIN,0,"SIGH IN !")
        item1?.setIcon(R.drawable.ic_launcher_foreground)
        item1?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)

        val itemExit = menu?.add(0,MENU_EXIT , 0 ,"EXIT .")
        itemExit?.setIcon(android.R.drawable.ic_lock_power_off)
        itemExit?.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)

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

    val MENU_ITEM_1 = 1
    val MENU_ITEM_2 = 2
    val MENU_ITEM_3 = 3

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        when(v?.id){
            R.id.demoB ->{
                //ui demo button
                menu?.add(0,MENU_ITEM_1,0,"COntinue")
                menu?.add(0,MENU_ITEM_2,0,"Cancel")
                menu?.add(0,MENU_ITEM_3,0,"Loading...")
            }
        }

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id){
            MENU_ITEM_1 ->{
                Log.d("MainActivity " ,"here $MENU_ITEM_1")
                val i =Intent(this,MainActivity::class.java)
                startActivity(i)
            }

            MENU_ITEM_2 ->{
                Log.d("MainActivity " ,"here $MENU_ITEM_2")
                finish()
            }

            MENU_ITEM_3 ->{
                Log.d("MainActivity " ,"here $MENU_ITEM_3")

                Toast.makeText(this,"Loading ..." , Toast.LENGTH_LONG).show()

            }

        }
        return super.onContextItemSelected(item)
    }
}













