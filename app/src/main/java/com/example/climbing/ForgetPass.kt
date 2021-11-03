package com.example.climbing

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forget_pass.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class ForgetPass: AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pass)
        auth = FirebaseAuth.getInstance()

       btn_email.setOnClickListener {
            emailUser()
        }

    }

    private fun emailUser() {
        if (Email.text.toString().isEmpty()) {
            Email.error = "Please enter email"
            Email.requestFocus()
            return
        }else if (!Patterns.EMAIL_ADDRESS.matcher(Email.text.toString()).matches()) {
            Email.error = "Please enter valid email"
            Email.requestFocus()
            return
        }

        ResetLoad.visibility = View.VISIBLE

        auth.sendPasswordResetEmail(Email.text.toString()).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                startActivity(Intent(this,LoginActivity::class.java))
                Toast.makeText(baseContext, "Email Sent. Follow the instructions provided.",
                    Toast.LENGTH_SHORT).show()
                finish()

            } else {
                Toast.makeText(baseContext, "Email failed to send. Try again after some time.",
                    Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,LoginActivity::class.java))
                     finish()
            }
        }
    }
}