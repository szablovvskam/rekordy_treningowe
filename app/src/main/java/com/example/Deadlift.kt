package com.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import kotlinx.android.synthetic.main.deadlift.*
import kotlinx.android.synthetic.main.deadlift.*
import kotlinx.android.synthetic.main.deadlift.switch2
import kotlinx.android.synthetic.main.deadlift.twojRekord2
import kotlinx.android.synthetic.main.deadlift.wpiszRekord2
import kotlinx.android.synthetic.main.push_press.*


class Deadlift: AppCompatActivity() {

    private val DEADLIFT_MAX: String =  "DEADLIFT_MAX"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deadlift)

        loadData()

        zapisz2.setOnClickListener {
            saveData()
        }

        d1.setOnClickListener {
            wypisz60ProcentCiezaru()
        }

        d2.setOnClickListener {
            wypisz70ProcentCiezaru()
        }

        d3.setOnClickListener {
            wypisz80ProcentCiezaru()
        }

        d4.setOnClickListener {
            wypisz90ProcentCiezaru()
        }

        findViewById<Button>(R.id.YouTube2).setOnClickListener {
            startActivity(Intent(this, VideoDeadlift::class.java))
        }
    }

    private fun wypisz90ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba2 = sharedPreferences1.getFloat(DEADLIFT_MAX, 0.0f)

        val wynik = 0.9f * liczba2
        val wynikString = String.format("%.2f", wynik)
        wynik2.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz80ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba2 = sharedPreferences1.getFloat(DEADLIFT_MAX, 0.0f)

        val wynik = 0.8f * liczba2
        val wynikString = String.format("%.2f", wynik)
        wynik2.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz70ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba2 = sharedPreferences1.getFloat(DEADLIFT_MAX, 0.0f)

        val wynik = 0.7f * liczba2
        val wynikString = String.format("%.2f", wynik)
        wynik2.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz60ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba2 = sharedPreferences1.getFloat(DEADLIFT_MAX, 0.0f)

        val wynik = 0.6f * liczba2
        val wynikString = String.format("%.2f", wynik)
        wynik2.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun saveData() {
        val wpisanaLiczba = wpiszRekord2.text.toString().toFloat()
        val wpisanaLiczbaString = String.format("%.2f", wpisanaLiczba)

        twojRekord2.text = "Twój rekord: $wpisanaLiczbaString kg"

        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences1.edit()
        editor.apply {
            putFloat(DEADLIFT_MAX, wpisanaLiczba)
        }.apply()

        Toast.makeText(this, "Zapisano rekord", Toast.LENGTH_LONG).show()
    }

    private fun loadData() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba2 = sharedPreferences1.getFloat(DEADLIFT_MAX, 0.0f)
        twojRekord2.text = "Twój rekord: $liczba2 kg"
    }

    }


