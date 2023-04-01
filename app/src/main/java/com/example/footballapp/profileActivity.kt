package com.example.footballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class profileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
    fun toastMe(view: View) {
        val toast = Toast.makeText(this, "Ведутся доработки", Toast.LENGTH_SHORT)
        toast.show()
    }
}