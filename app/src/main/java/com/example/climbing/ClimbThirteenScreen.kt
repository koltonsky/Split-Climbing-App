package com.example.climbing

import android.content.Intent
import android.os.Bundle
import android.content.Context
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.climb_thirteen_screen.*

class ClimbThirteenScreen: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.climb_thirteen_screen)

        backThirteen.setOnClickListener {
            startActivity(Intent(this, ClimbList::class.java))
        }

        val chk1 = findViewById<CheckBox>(R.id.checkBoxThirteen)
        val database = getSharedPreferences("database", Context.MODE_PRIVATE)
        val checkMark = getSharedPreferences("checking", Context.MODE_PRIVATE)
        val isChecked = checkMark.getBoolean("climbCheckThirteen", false)

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
                    putBoolean("climbCheckThirteen", true)
                }.apply()
            }

            else {
                savedScore -= 1000
                val stringScore: String = savedScore.toString()
                database.edit().apply {
                    putString("getScore", stringScore)
                }.apply()

                checkMark.edit().apply {
                    putBoolean("climbCheckThirteen", false)
                }.apply()
            }
        }

        if (isChecked) {
            chk1.isChecked = true
        }

    }
}
