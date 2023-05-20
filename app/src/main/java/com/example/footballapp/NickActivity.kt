package com.example.footballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.*

class NickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nick)
    }
    lateinit var edit: EditText
    lateinit var txtShow: TextView

    public fun read(view: View) {
        try {
            val fileInput: FileInputStream = openFileInput("surname.txt")
            val reader: InputStreamReader =  InputStreamReader(fileInput)
            val buffer: BufferedReader = BufferedReader(reader)
            val strBuffer: StringBuffer = StringBuffer()
            var lines: String
            lines = buffer.readLine()
            while (lines != null) {
                strBuffer.append(lines + "\n")
                lines = buffer.readLine()
            }
            txtShow.setText(strBuffer.toString())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    public fun write(view: View) {
        var myTxt: String = edit.text.toString()
        try {
            val fileOutput: FileOutputStream = openFileOutput("surname.txt", MODE_PRIVATE)
            fileOutput.write(myTxt.toByteArray())
            fileOutput.close()
            edit.setText("")
            Toast.makeText(this, "Save", Toast.LENGTH_LONG).show()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}