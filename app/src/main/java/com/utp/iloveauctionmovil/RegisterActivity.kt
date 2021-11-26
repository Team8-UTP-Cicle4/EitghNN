package com.utp.iloveauctionmovil

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun auth (view: View){
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }


}