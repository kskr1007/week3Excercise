package com.example.week3intent

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        // add listener on this field
        myUsername.addTextChangedListener(myTextWatcher)

        myButton.setOnClickListener {
            // get username
            val username = myUsername.text.toString()
            // check if blank
            if(username.isBlank()){
                // error message
                Toast.makeText(applicationContext, "Username needed!", Toast.LENGTH_LONG).show()

            }
            // move to next activity
            else {
                val mySecondScreenIntent = Intent(this, MainActivity2::class.java)
                mySecondScreenIntent.putExtra("location", "my city")
                startActivity(mySecondScreenIntent)
            }
        }
    }

    private val myTextWatcher: TextWatcher = object: TextWatcher{
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {

        }

        override fun onTextChanged(
            s: CharSequence?,
            start: Int,
            before: Int,
            count: Int
        ) {
            // getting the username while it is being typed
            val inputtedUsername = myUsername.text.toString()
            // boolean to enable login once username has a value
            val enableButton = inputtedUsername.isNotBlank()
            // enable button if true
            myButton.isEnabled = enableButton
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