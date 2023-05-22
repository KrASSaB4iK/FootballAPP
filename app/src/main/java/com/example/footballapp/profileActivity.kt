package com.example.footballapp

import android.content.Intent
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
        val myToast = Toast.makeText(this, "Ведется доработка", Toast.LENGTH_SHORT)
        myToast.show()
    }
    fun infoOpen1(view: View) {
        val infoOpenIntent = Intent(this, NickActivity::class.java)
        startActivity(infoOpenIntent)
    }
}