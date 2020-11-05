package com.example.android.localstorage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        getUserDetails()
        buttonLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun getUserDetails() {
        val mPref = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val name = mPref.getString(Constants.NAME_PREF, "")
        val email = mPref.getString(Constants.EMAIL_PREF, "")
        val school = mPref.getString(Constants.SCHOOL_PREF, "")

        text_name.text = name
        text_email.text = email
        text_school.text = school
    }
}