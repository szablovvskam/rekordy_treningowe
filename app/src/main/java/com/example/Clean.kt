package com.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.clean.*
import kotlinx.android.synthetic.main.front_squat.*

class Clean: AppCompatActivity() {

    private val CLEAN_MAX: String = "CLEAN_MAX"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clean)

        loadData()

        zapisz5.setOnClickListener {
            saveData()
        }

        c1.setOnClickListener {
            wypisz60ProcentCiezaru()
        }

        c2.setOnClickListener {
            wypisz70ProcentCiezaru()
        }

        c3.setOnClickListener {
            wypisz80ProcentCiezaru()
        }

        c4.setOnClickListener {
            wypisz90ProcentCiezaru()
        }

        findViewById<Button>(R.id.YouTube5).setOnClickListener {
            startActivity(Intent(this, VideoClean::class.java))
        }
    }

    private fun wypisz90ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(CLEAN_MAX, 0.0f)

        val wynik = 0.9f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik5.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz80ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(CLEAN_MAX, 0.0f)

        val wynik = 0.8f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik5.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz70ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(CLEAN_MAX, 0.0f)

        val wynik = 0.7f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik5.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz60ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(CLEAN_MAX, 0.0f)

        val wynik = 0.6f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik5.text = "Twój obecny ciężar to: $wynikString kg"
    }

        private fun saveData() {
            val wpisanaLiczba = wpiszRekord5.text.toString().toFloat()
            val wpisanaLiczbaString = String.format("%.2f", wpisanaLiczba)

            twojRekord5.text = "Twój rekord: $wpisanaLiczbaString kg"

            val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putFloat(CLEAN_MAX, wpisanaLiczba)
            }.apply()

            Toast.makeText(this, "Zapisano rekord", Toast.LENGTH_LONG).show()
        }

        private fun loadData() {
            val sharedPreferences5 = getPreferences(Context.MODE_PRIVATE)
            val liczba = sharedPreferences5.getFloat(CLEAN_MAX, 0.0f)
            twojRekord5.text = "Twój rekord: $liczba kg"
        }
    }


