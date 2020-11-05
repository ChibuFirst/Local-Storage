package com.example.android.localstorage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        removeTextInputErrors()
        buttonSignup.setOnClickListener { validateUserInputs() }
        buttonLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun validateUserInputs() {
        when {
            text_input_name.editText?.text?.isEmpty()!! -> {
                text_input_name.error = "Name required."
                text_input_name.requestFocus()
                return
            }
            text_input_email.editText?.text?.isEmpty()!! -> {
                text_input_email.error = "Email required."
                text_input_email.requestFocus()
                return
            }
            text_input_school.editText?.text?.isEmpty()!! -> {
                text_input_school.error = "School required."
                text_input_school.requestFocus()
                return
            }
            text_input_password.editText?.text?.isEmpty()!! -> {
                text_input_password.error = "Password required."
                text_input_password.requestFocus()
                return
            }
            else -> signUpUser(
                text_input_name.editText?.text.toString(),
                text_input_email.editText?.text.toString(),
                text_input_school.editText?.text.toString(),
                text_input_password.editText?.text.toString()
            )
        }
    }

    private fun signUpUser(name: String, email: String, school: String, password: String) {
        val mPref = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val mEditor = mPref.edit()
        mEditor.putString(Constants.NAME_PREF, name)
        mEditor.putString(Constants.EMAIL_PREF, email)
        mEditor.putString(Constants.SCHOOL_PREF, school)
        mEditor.putString(Constants.PASSWORD_PREF, password)
        mEditor.apply()
        Toast.makeText(this, "User details saved.", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun removeTextInputErrors() {
        text_input_name.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()) {
                    text_input_name.error = null
                }
            }
        })

        text_input_email.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()) {
                    text_input_email.error = null
                }
            }
        })

        text_input_school.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()) {
                    text_input_school.error = null
                }
            }
        })

        text_input_password.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()) {
                    text_input_password.error = null
                }
            }
        })
    }
}