package com.utp.iloveauctionmovil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val ingresar: Button = findViewById(R.id.ingresar)

    }

    fun siguienteRegistro(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun setup() {
        val ingresar: Button = findViewById(R.id.ingresar)
        val email: EditText = findViewById(R.id.email)
        val clave: EditText = findViewById(R.id.Password)
        title = "autenticacion"
        ingresar.setOnClickListener {
            if (email.text.isNotEmpty() && clave.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email.text.toString(), clave.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                        }
                        else{
                            showalert()
                        }
                    }
            }
        }
    }

    private fun showalert(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog:AlertDialog=builder.create()
        dialog.show()
    }



}

