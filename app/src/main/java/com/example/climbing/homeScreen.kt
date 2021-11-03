package com.example.climbing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main1.*

private lateinit var auth: FirebaseAuth

    var savedScore = 0
    class HomeScreen : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main1)

            toClimbList.setOnClickListener {
                startActivity(Intent(this, ClimbList::class.java))
                finish()
            }
            btn_logout.setOnClickListener {
                logout()
            }
            val preferences = getSharedPreferences("database", Context.MODE_PRIVATE)
            val savedFinalScore = preferences.getString("getScore", "0")

            val checkMark = getSharedPreferences("checking", Context.MODE_PRIVATE)

            Log.d("Kolton", "Your score is: $savedFinalScore")
            getScore.text = savedFinalScore
        }

        fun logout() {
            val shared =
                getSharedPreferences("login", Context.MODE_PRIVATE)
            auth.signOut()
            val prefEdit = shared.edit()
            prefEdit.putString("name", null)
            prefEdit.putString("Psw", null)
            prefEdit.apply()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
    }


    }