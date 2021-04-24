package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.wybierz_cwiczenie.*

class WybierzCwiczenie: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wybierz_cwiczenie)



       findViewById<Button>(R.id.pushPress).setOnClickListener { startActivity(Intent(this,PushPress::class.java)) }

        findViewById<Button>(R.id.deadlift).setOnClickListener { startActivity(Intent(this,Deadlift::class.java)) }

       findViewById<Button>(R.id.strictPress).setOnClickListener { startActivity(Intent(this,StrictPress::class.java)) }

        findViewById<Button>(R.id.frontSquat).setOnClickListener { startActivity(Intent(this,FrontSquat::class.java)) }

        findViewById<Button>(R.id.clean).setOnClickListener { startActivity(Intent(this,Clean::class.java)) }

        findViewById<Button>(R.id.backSquat).setOnClickListener { startActivity(Intent(this,BackSquat::class.java)) }

//        logout.setOnClickListener{
//            FirebaseAuth.getInstance().singOut()
//
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }

    }
}

