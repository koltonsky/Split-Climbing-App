package com.example.climbing

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_climb_create.*


class ClimbingGenerator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_climb_create)

        btn_create.setOnClickListener(View.OnClickListener {
            newClimb()
            }


        )}

    var i: Int = 1
    var first: Boolean = true
    private fun newClimb() {
        val constraintLayout: ConstraintLayout = findViewById(R.id.RootCon)
        var newButton = Button(this)
        i++
        constraintLayout.addView(newButton)
        val params = newButton.layoutParams as ConstraintLayout.LayoutParams
        newButton.id = i
        params.height = WRAP_CONTENT
        if(first){
            params.topToTop = RootCon.id
            params.topMargin = 100
        }
        else {
            var old = i - 1
            params.topToBottom = old
            params.topMargin = 0

        }

        params.height = 400
        params.leftToLeft = RootCon.id
        params.width = RootCon.id
        first = false
        newButton.id = i
        newButton.text = "Climb #$i"
        newButton.alpha = 0.0F

        var newDivider = View(this)
        constraintLayout.addView(newDivider)
        val dividerParams = newDivider.layoutParams as ConstraintLayout.LayoutParams
        newDivider.setBackgroundColor(Color.parseColor("#000000"))
        dividerParams.height = 20
        dividerParams.topToBottom = newButton.id
    }


    }