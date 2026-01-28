package com.example.week3intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var myUsername: EditText
    private lateinit var myPassword: EditText
    private lateinit var myButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleLog("in on Create")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myUsername = findViewById(R.id.username)
        myPassword = findViewById(R.id.password)
        myButton = findViewById(R.id.button)

        myButton.setOnClickListener {
            val mySecondScreenIntent = Intent(this, MainActivity2::class.java)
            mySecondScreenIntent.putExtra("location", "my city")
            startActivity(mySecondScreenIntent)
        }
    }
    override fun onPause(){
        super.onPause()
        lifecycleLog("in on pause")
    }
    override fun onResume(){
        super.onResume()
        lifecycleLog("in on resume")
    }
    override fun onDestroy(){
        super.onDestroy()
        lifecycleLog("in on resume")
    }
    private fun lifecycleLog(msg: String){

        Log.d("Lifecycle log", msg)
    }
}