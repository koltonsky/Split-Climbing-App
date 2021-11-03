package com.example.climbing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()


        btn_sign_up.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()
        }

        Forget_Pass.setOnClickListener {
            startActivity(Intent(this,ForgetPass::class.java))
            finish()
        }

        btn_sign_in.setOnClickListener {
            login()
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        val shared =
            getSharedPreferences("login", Context.MODE_PRIVATE)
        val name = shared.getString("name", null)
        val pss = shared.getString("Psw", null)

        if(name !=  null && pss != null){
            loading()
            welcomemsg.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(name.toString(), pss.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, HomeScreen::class.java))
                    }
                }
        }
        updateUI(currentUser)
    }

    fun updateUI(currentUser: FirebaseUser?) {

    }

    private fun login() {
        if (Email.text.toString().isEmpty()) {
            Email.error = "Please enter your email"
            Email.requestFocus()
            return
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email.text.toString()).matches()) {
            Email.error = "Please enter a valid email"
            Email.requestFocus()
            return
        }else if (password.text.toString().isEmpty()) {
            password.error = "Please enter your password"
            password.requestFocus()
            return
        }else loading()
        auth.signInWithEmailAndPassword(Email.text.toString(), password.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val sp =
                        getSharedPreferences("login", Context.MODE_PRIVATE)
                    val ed = sp.edit()
                    ed.putString("name", Email.text.toString())
                    ed.putString("Psw", password.text.toString())
                    ed.apply()
                    startActivity(Intent(this,HomeScreen::class.java))
                    finish()
                }else{
                    Toast.makeText(baseContext, "Could not Login. Try again.",
                        Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,LoginActivity::class.java))
                    finish()
                }
            }
    }

    private fun loading(){
        progressBar.visibility = View.VISIBLE
        opacityLoading.visibility = View.VISIBLE
        password.visibility = View.GONE
        Email.visibility = View.GONE
        Forget_Pass.visibility = View.GONE
        btn_sign_up.visibility = View.GONE
        btn_sign_in.visibility = View.GONE
        password_text.visibility = View.GONE
        signuptext.visibility = View.GONE
    }
}
