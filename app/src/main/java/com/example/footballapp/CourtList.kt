package com.example.footballapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CourtList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_court_list)
    }
    fun courtExOpen (view: View) {     //Call chat
        val courtExOpen = Intent(this, CourtExamleActivity::class.java)
        startActivity(courtExOpen)
    }
}