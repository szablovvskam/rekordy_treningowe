package com.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import kotlinx.android.synthetic.main.front_squat.*
import kotlinx.android.synthetic.main.strict_press.*

class FrontSquat: AppCompatActivity() {

    private val FRONT_SQUAT_MAX: String =  "FRONT_SQUAT_MAX"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.front_squat)

        loadData()

        zapisz4.setOnClickListener {
            saveData()
        }

        f1.setOnClickListener {
            wypisz60ProcentCiezaru()
        }

        f2.setOnClickListener {
            wypisz70ProcentCiezaru()
        }

        f3.setOnClickListener {
            wypisz80ProcentCiezaru()
        }

        f4.setOnClickListener {
            wypisz90ProcentCiezaru()
        }

        findViewById<Button>(R.id.YouTube4).setOnClickListener {
            startActivity(Intent(this, VideoFrontSquat::class.java))
        }

    }

    private fun wypisz90ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(FRONT_SQUAT_MAX, 0.0f)

        val wynik = 0.9f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik4.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz80ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(FRONT_SQUAT_MAX, 0.0f)

        val wynik = 0.8f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik4.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz70ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(FRONT_SQUAT_MAX, 0.0f)

        val wynik = 0.7f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik4.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz60ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(FRONT_SQUAT_MAX, 0.0f)

        val wynik = 0.6f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik4.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun saveData() {
        val wpisanaLiczba = wpiszRekord4.text.toString().toFloat()
        val wpisanaLiczbaString = String.format("%.2f", wpisanaLiczba)

        twojRekord4.text = "Twój rekord: $wpisanaLiczbaString kg"

        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putFloat(FRONT_SQUAT_MAX, wpisanaLiczba)
        }.apply()

        Toast.makeText(this, "Zapisano rekord", Toast.LENGTH_LONG).show()
    }

    private fun loadData() {
        val sharedPreferences4 = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences4.getFloat(FRONT_SQUAT_MAX,0.0f)
        twojRekord4.text = "Twój rekord: $liczba kg"
    }
}

