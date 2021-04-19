package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.R

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


    }
}

