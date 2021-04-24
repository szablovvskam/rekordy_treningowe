
package com.example

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        findViewById<TextView>(R.id.tv_register).setOnClickListener { startActivity(Intent(this,Register::class.java)) }

        findViewById<Button>(R.id.login).setOnClickListener { startActivity(Intent(this,Start::class.java)) }


    login.setOnClickListener{
        when {
            TextUtils.isEmpty(login_email.text.toString().trim { it <= ' '}) -> {
                Toast.makeText(
                        this@MainActivity,
                        "Prosze wpisać hasło.",
                        Toast.LENGTH_SHORT
                ).show()
            }
            else -> {

                val email: String = login_email.text.toString().trim { it <= ' ' }
                val password: String = login_password.text.toString().trim { it <= ' ' }

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            if (task.isSuccessful) {
                                Toast.makeText(
                                        this@MainActivity,
                                        "Zostałeś poprawnie zalogowany",
                                        Toast.LENGTH_SHORT
                                ).show()

                                val intent =
                                        Intent(this, Start::class.java)
                                intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra(
                                        "user_id",
                                        FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {

                                Toast.makeText(
                                        this@MainActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                ).show()


                            }
                        }

            }
            }
        }
    }
}
