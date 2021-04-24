package com.example

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.register.*

class Register: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        findViewById<TextView>(R.id.tv_login).setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }

        register.setOnClickListener{
            when{
                TextUtils.isEmpty(register_email.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                            this@Register,
                            "Podaj swój e-mail.",
                            Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(register_password.text.toString().trim { it <= ' '}) -> {
                    Toast.makeText(
                            this@Register,
                            "Podaj hasło",
                            Toast.LENGTH_SHORT
                    )
                }
                else -> {

                    val email: String = register_email.text.toString().trim { it <= ' '}
                    val password: String = register_password.text.toString().trim { it <= ' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(
                                    OnCompleteListener<AuthResult> { task ->

                                        //jezeli rejestracja sie powiodla
                                        if (task.isSuccessful) {

                                            val firebaseUser: FirebaseUser = task.result!!.user!!

                                            Toast.makeText(
                                                    this@Register,
                                                    "Rejestracja się powiodła.",
                                                    Toast.LENGTH_SHORT
                                            ).show()


                                            val intent =
                                                    Intent(this@Register, MainActivity::class.java)
                                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                            intent.putExtra("user_id", firebaseUser.uid)
                                            intent.putExtra("email_id", email)
                                            startActivity(intent)
                                            finish()
                                        } else {
                                            //jak rejestracja sie nie powiedzie
                                            Toast.makeText(
                                                    this@Register,
                                                    task.exception!!.message.toString(),
                                                    Toast.LENGTH_SHORT
                                            ).show()


                                        }
                                    })
                }

            }
        }

    }
}