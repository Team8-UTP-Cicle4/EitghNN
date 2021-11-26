package com.utp.iloveauctionmovil

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }

    fun siguienteRegistro (view: View){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}