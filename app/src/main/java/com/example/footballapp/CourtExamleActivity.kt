package com.example.footballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class CourtExamleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_court_examle)
    }
    fun toastMe(view: View) {
        val myToast = Toast.makeText(this, "Ведется доработка", Toast.LENGTH_SHORT)
        myToast.show()
    }
}