package com.example.climbing

import android.content.Intent
import android.os.Bundle
import android.content.Context
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.climbing.R
import com.example.climbing.savedScore
import kotlinx.android.synthetic.main.climb_eleven_screen.*

class ClimbElevenScreen: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.climb_eleven_screen)

        backEleven.setOnClickListener {
            startActivity(Intent(this, ClimbList::class.java))
        }

        val chk1 = findViewById<CheckBox>(R.id.checkBoxEleven)
        val database = getSharedPreferences("database", Context.MODE_PRIVATE)
        val checkMark = getSharedPreferences("checking", Context.MODE_PRIVATE)
        val isChecked = checkMark.getBoolean("climbCheckEleven", false)

        chk1.setOnClickListener { v ->
            val checked1 = (v as CheckBox).isChecked
            val box1: Boolean
            box1 = checked1

            if (box1) {
                savedScore += 1000
                val stringScore: String = savedScore.toString()
                database.edit().apply {
                    putString("getScore", stringScore)
                }.apply()

                checkMark.edit().apply {
                    putBoolean("climbCheckEleven", true)
                }.apply()
            }

            else {
                savedScore -= 1000
                val stringScore: String = savedScore.toString()
                database.edit().apply {
                    putString("getScore", stringScore)
                }.apply()

                checkMark.edit().apply {
                    putBoolean("climbCheckEleven", false)
                }.apply()
            }
        }

        if (isChecked) {
            chk1.isChecked = true
        }

    }
}
