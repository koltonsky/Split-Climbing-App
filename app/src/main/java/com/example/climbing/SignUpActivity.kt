package com.example.climbing

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*


class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    var cal = Calendar.getInstance()
    var date: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()

        btn_sign_up.setOnClickListener {
            signUpUser()
        }
        btn_birthday.setOnClickListener {
            val dialog: DatePickerDialog = DatePickerDialog(this,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH))
           dialog.datePicker.maxDate = Date().time
            dialog.show()
        }
    }
    private fun signUpUser() {

        var firstname: String = firstName.text.toString()
        var lastname: String = lastName.text.toString()
        var fullname: String = "$firstname $lastname"
        if (username.text.toString().isEmpty()) {
            username.error = "Please enter email"
            username.requestFocus()
            return
        }else if(!Patterns.EMAIL_ADDRESS.matcher(username.text.toString()).matches())
        {
            username.error = "Please enter valid email"
            username.requestFocus()
            return

        }else if(password.text.toString().isEmpty())
        {
            password.error = "Please enter password"
            password.requestFocus()
            return

        }else if(password.text.toString() != password2.text.toString())
        {
            password2.error = "Please Ensure Passwords Match"
            password2.requestFocus()
            return
        }else if(password.length() < 6)
        {
            password.error = "Must be six characters or more"
            password.requestFocus()
            return
        }else if(firstname.isEmpty())
        {
            firstName.error = "Please enter your first name"
            firstName.requestFocus()
            return
        }else if(lastname.isEmpty())
        {
            lastName.error = "Please enter your last name"
            lastName.requestFocus()
            return
        }else{
            SignUpLoad.visibility = View.VISIBLE
            opacityLoading.visibility = View.VISIBLE
            btn_sign_up.visibility = View.GONE
            username.inputType = InputType.TYPE_NULL
            firstName.inputType = InputType.TYPE_NULL
            lastName.inputType = InputType.TYPE_NULL
            password.visibility = View.GONE
            password2.visibility = View.GONE
            btn_birthday.visibility = View.GONE
            birthday.inputType = InputType.TYPE_NULL
        }

        auth.createUserWithEmailAndPassword(username.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = FirebaseAuth.getInstance().currentUser

                    val nameUpdate =
                        UserProfileChangeRequest.Builder().setDisplayName(fullname).build()

                    user!!.updateProfile(nameUpdate)
                    Toast.makeText(
                        baseContext, "Account Created. Please check your email to verify your account.",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()

                } else {
                    Toast.makeText(
                        baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
    }
    private val dateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }

    private fun updateDateInView() {
        var myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        var date: TextView? = birthday
        date!!.text = sdf.format(cal.time)
    }
}
