package com.example

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import kotlinx.android.synthetic.main.deadlift.*
import kotlinx.android.synthetic.main.strict_press.*
import kotlinx.android.synthetic.main.strict_press.*
import kotlinx.android.synthetic.main.strict_press.switch3
import kotlinx.android.synthetic.main.strict_press.twojRekord3
import kotlinx.android.synthetic.main.strict_press.wpiszRekord3

class StrictPress: AppCompatActivity() {

    private val STRICT_PRESS_MAX: String =  "STRICT_PRESS_MAX"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.strict_press)

        loadData()

        zapisz3.setOnClickListener {
            saveData()
        }

        s1.setOnClickListener {
            wypisz60ProcentCiezaru()
        }

        s2.setOnClickListener {
            wypisz70ProcentCiezaru()
        }

        s3.setOnClickListener {
            wypisz80ProcentCiezaru()
        }

        s4.setOnClickListener {
            wypisz90ProcentCiezaru()
        }

        findViewById<Button>(R.id.YouTube3).setOnClickListener {
            startActivity(Intent(this, VideoStrictPress::class.java))
        }
    }

    private fun wypisz90ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(STRICT_PRESS_MAX, 0.0f)

        val wynik = 0.9f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik3.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz80ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(STRICT_PRESS_MAX, 0.0f)

        val wynik = 0.8f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik3.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz70ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(STRICT_PRESS_MAX, 0.0f)

        val wynik = 0.7f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik3.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz60ProcentCiezaru() {
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences.getFloat(STRICT_PRESS_MAX, 0.0f)

        val wynik = 0.6f * liczba
        val wynikString = String.format("%.2f", wynik)
        wynik3.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun saveData() {
        val wpisanaLiczba = wpiszRekord3.text.toString().toFloat()
        val wpisanaLiczbaString = String.format("%.2f", wpisanaLiczba)

        twojRekord3.text = "Twój rekord: $wpisanaLiczbaString kg"

        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putFloat(STRICT_PRESS_MAX, wpisanaLiczba)
        }.apply()

        Toast.makeText(this, "Zapisano rekord", Toast.LENGTH_LONG).show()
    }

    private fun loadData() {
        val sharedPreferences3 = getPreferences(Context.MODE_PRIVATE)
        val liczba = sharedPreferences3.getFloat(STRICT_PRESS_MAX,0.0f)
        twojRekord3.text = "Twój rekord: $liczba kg"
    }
}

