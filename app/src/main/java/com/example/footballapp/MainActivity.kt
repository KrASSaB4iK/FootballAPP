package com.example.footballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {        //Initialisation
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun mapOpen(view: View) {       //Call map
        val mapOpenIntent = Intent(this, MapActivity::class.java)
        startActivity(mapOpenIntent)
    }
    fun chatOpen (view: View) {     //Call chat
        val chatOpen = Intent(this, ChatActivity::class.java)
        startActivity(chatOpen)
    }
    fun courtOpen (view: View) {        //Call court
        val courtOpen = Intent(this, CourtList::class.java)
        startActivity(courtOpen)
    }
    fun profileOpen(view: View) {
        val profileOpen = Intent(this, profileActivity::class.java)
        startActivity(profileOpen)
    }
}