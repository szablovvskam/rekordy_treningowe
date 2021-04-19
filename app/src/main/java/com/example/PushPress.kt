package com.example

import android.content.Context
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.R
import kotlinx.android.synthetic.main.push_press.*
import kotlinx.android.synthetic.main.push_press.twojRekord1
import kotlinx.android.synthetic.main.push_press.wpiszRekord1

class PushPress: AppCompatActivity() {

    private val PUSH_PRESS_MAX: String =  "PUSH_PRESS_MAX"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.push_press)
        loadData()
        zapisz1.setOnClickListener {
          saveData()
        }

        p1.setOnClickListener {
            wypisz60ProcentCiezaru()
        }

        p2.setOnClickListener {
            wypisz70ProcentCiezaru()
        }

        p3.setOnClickListener {
            wypisz80ProcentCiezaru()
        }

        p4.setOnClickListener {
            wypisz90ProcentCiezaru()
        }

        findViewById<Button>(R.id.YouTube).setOnClickListener {
            startActivity(Intent(this, VideoPushPress::class.java))
        }
    }


    private fun wypisz90ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba1 = sharedPreferences1.getFloat(PUSH_PRESS_MAX, 0.0f)

        val wynik = 0.9 * liczba1
        val wynikString = String.format("%.2f", wynik)
        wynik1.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz80ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba1 = sharedPreferences1.getFloat(PUSH_PRESS_MAX, 0.0f)

        val wynik = 0.8f * liczba1
        val wynikString = String.format("%.2f", wynik)
        wynik1.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz70ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba1 = sharedPreferences1.getFloat(PUSH_PRESS_MAX, 0.0f)

        val wynik = 0.7f * liczba1
        val wynikString = String.format("%.2f", wynik)
        wynik1.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun wypisz60ProcentCiezaru() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba1 = sharedPreferences1.getFloat(PUSH_PRESS_MAX, 0.0f)

        val wynik = 0.6f * liczba1
        val wynikString = String.format("%.2f", wynik)
        wynik1.text = "Twój obecny ciężar to: $wynikString kg"
    }

    private fun saveData() {
        val wpisanaLiczba = wpiszRekord1.text.toString().toFloat()
        val wpisanaLiczbaString = String.format("%.2f", wpisanaLiczba)

        twojRekord1.text = "Twój rekord: $wpisanaLiczbaString kg"

        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val editor1 = sharedPreferences1.edit()
        editor1.apply {
            putFloat(PUSH_PRESS_MAX, wpisanaLiczba)
        }.apply()

        Toast.makeText(this, "Zapisano rekord", Toast.LENGTH_LONG).show()
    }


    private fun loadData() {
        val sharedPreferences1 = getPreferences(Context.MODE_PRIVATE)
        val liczba1 = sharedPreferences1.getFloat(PUSH_PRESS_MAX, 0.0f)
        twojRekord1.text = "Twój rekord: $liczba1 kg"
    }
}



