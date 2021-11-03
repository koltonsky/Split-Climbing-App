package com.example.climbing

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.climbing.R
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.climb_list.*
import kotlinx.android.synthetic.main.climb_one_screen.*
import java.io.File


class ClimbList: AppCompatActivity() {

    lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.climb_list)


        testButton.setOnClickListener {
            startActivity(Intent(this, HomeScreen::class.java))
        }
        buttonClimbOne.setOnClickListener {
            startActivity(Intent(this, ClimbOneScreen::class.java))
        }

        buttonClimbTwo.setOnClickListener {
            startActivity(Intent(this, ClimbTwoScreen::class.java))
        }

        buttonClimbThree.setOnClickListener {
            startActivity(Intent(this, ClimbThreeScreen::class.java))
        }

        buttonClimbFour.setOnClickListener {
            startActivity(Intent(this, ClimbFourScreen::class.java))
        }

        buttonClimbFive.setOnClickListener {
            startActivity(Intent(this, ClimbFiveScreen::class.java))
        }

        buttonClimbSix.setOnClickListener {
            startActivity(Intent(this, ClimbSixScreen::class.java))
        }

        buttonClimbSeven.setOnClickListener {
            startActivity(Intent(this, ClimbSevenScreen::class.java))
        }

        buttonClimbEight.setOnClickListener {
            startActivity(Intent(this, ClimbEightScreen::class.java))
        }

        buttonClimbNine.setOnClickListener {
            startActivity(Intent(this, ClimbNineScreen::class.java))
        }

        buttonClimbTen.setOnClickListener {
            startActivity(Intent(this, ClimbTenScreen::class.java))
        }

        buttonClimbEleven.setOnClickListener {
            startActivity(Intent(this, ClimbElevenScreen::class.java))
        }

        buttonClimbTwelve.setOnClickListener {
            startActivity(Intent(this, ClimbTwelveScreen::class.java))
        }

        buttonClimbThirteen.setOnClickListener {
            startActivity(Intent(this, ClimbThirteenScreen::class.java))
        }

        buttonClimbFourteen.setOnClickListener {
            startActivity(Intent(this, ClimbFourteenScreen::class.java))
        }

        buttonClimbFifteen.setOnClickListener {
            startActivity(Intent(this, ClimbFifteenScreen::class.java))
        }

        buttonClimbSixteen.setOnClickListener {
            startActivity(Intent(this, ClimbSixteenScreen::class.java))
        }

        buttonClimbSeventeen.setOnClickListener {
            startActivity(Intent(this, ClimbSeventeenScreen::class.java))
        }

        buttonClimbEighteen.setOnClickListener {
            startActivity(Intent(this, ClimbEighteenScreen::class.java))
        }

        buttonClimbNineteen.setOnClickListener {
            startActivity(Intent(this, ClimbNineteenScreen::class.java))
        }

        buttonClimbTwenty.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyScreen::class.java))
        }

        buttonClimbTwentyOne.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyOneScreen::class.java))
        }

        buttonClimbTwentyTwo.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyTwoScreen::class.java))
        }

        buttonClimbTwentyThree.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyThreeScreen::class.java))
        }

        buttonClimbTwentyFour.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyFourScreen::class.java))
        }

        buttonClimbTwentyFive.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyFiveScreen::class.java))
        }

        buttonClimbTwentySix.setOnClickListener {
            startActivity(Intent(this, ClimbTwentySixScreen::class.java))
        }

        buttonClimbTwentySeven.setOnClickListener {
            startActivity(Intent(this, ClimbTwentySevenScreen::class.java))
        }

        buttonClimbTwentyEight.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyEightScreen::class.java))
        }

        buttonClimbTwentyNine.setOnClickListener {
            startActivity(Intent(this, ClimbTwentyNineScreen::class.java))
        }

        buttonClimbThirty.setOnClickListener {
            startActivity(Intent(this, ClimbThirtyScreen::class.java))
        }

    }
    private var storageRef = storage.reference
    val pathReference = storageRef.child("images/stars.jpg")

    val gsReference = storage.getReferenceFromUrl("gs://bucket/Regina Climbing League /IMG_5202.JPG")


}