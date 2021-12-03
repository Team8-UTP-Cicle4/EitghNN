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
        setup()
    }


    fun siguienteRegistro(view: View) {
        val intent1 = Intent(this, RegisterActivity::class.java)
        startActivity(intent1)
    }

   /* fun siguientePrincipal(view: View) {
        val intent2 = Intent(this, PrincipalActivity::class.java)
        startActivity(intent2)
    }*/

    private fun setup() {
        val login: Button = findViewById(R.id.login)
        val email: EditText = findViewById(R.id.email3)
        val clave: EditText = findViewById(R.id.Password)
        title = "autenticacion"
        login.setOnClickListener {
            if (email.text.isNotEmpty() && clave.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email.text.toString(), clave.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(
                                it.result?.user?.email ?: "",
                                PrincipalActivity.ProviderType.BASIC
                            )
                        } else {
                            showalert()
                        }
                    }
            }
        }
    }

    private fun showalert() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showHome(email: String, provider: PrincipalActivity.ProviderType) {
        val homeIntent = Intent(this, PrincipalActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}

