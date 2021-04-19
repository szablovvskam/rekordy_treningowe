package com.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.back_squat.*
import kotlinx.android.synthetic.main.clean.*

class BackSquat: AppCompatActivity() {

    private val BACK_SQUAT_MAX: String = "BACK_SQUAT_MAX"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.back_squat)

        loadData()

        zapisz6.setOnClickListener {
            saveData()
        }

        b1.setOnClickListener {
            wypisz60ProcentCiezaru()
        }

        b2.setOnClickListener {
            wypisz70ProcentCiezaru()
        }

        b3.setOnClickListener {
            wypisz80ProcentCiezaru()
        }

        b4.setOnClickListener {
            wypisz90ProcentCiezaru()
        }

        findViewById<Button>(R.id.YouTube6).setOnClickListener {
            startActivity(Intent(this, VideoBackSquat::class.java))
        }
    }

    private fun wypisz90ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(BACK_SQUAT_MAX, 0.0f)

        val wynik = 0.9f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik6.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz80ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(BACK_SQUAT_MAX, 0.0f)

        val wynik = 0.8f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik6.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz70ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(BACK_SQUAT_MAX, 0.0f)

        val wynik = 0.7f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik6.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz60ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(BACK_SQUAT_MAX, 0.0f)

        val wynik = 0.6f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik6.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun saveData() {
        val wpisanaLiczba = wpiszRekord6.text.toString().toFloat()
        val wpisanaLiczbaString = String.format("%.2f", wpisanaLiczba)

        twojRekord6.text = "Twój rekord: $wpisanaLiczbaString kg"

        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putFloat(BACK_SQUAT_MAX, wpisanaLiczba)
        }.apply()

        Toast.makeText(this, "Zapisano rekord", Toast.LENGTH_LONG).show()
    }

    private fun loadData() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(BACK_SQUAT_MAX, 0.0f)

        twojRekord6.text = "Twój rekord: $liczba kg"
    }
}

