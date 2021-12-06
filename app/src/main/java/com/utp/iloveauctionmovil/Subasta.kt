package com.utp.iloveauctionmovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Subasta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subasta)
    }

    fun volver(view: View) {
        val intent1 = Intent(this, PrincipalActivity::class.java)
        startActivity(intent1)
    }
}