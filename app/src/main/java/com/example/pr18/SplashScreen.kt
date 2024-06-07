package com.example.pr18

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class SplashScreen : AppCompatActivity() {
    private lateinit var TextView: TextView
    private lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val spinner = findViewById<Spinner>(R.id.spinner)
        var selecte = spinner.selectedItemPosition
        pref = getPreferences(MODE_PRIVATE)
        if (pref.getInt("spinner", 0) != 0) {
            selecte = pref.getInt("spinner", 0)
        }
        f(selecte)
    }

    fun spin(v: View) {
        val spinner = findViewById<Spinner>(R.id.spinner)
        val selecte = spinner.selectedItemPosition
        pref = getPreferences(MODE_PRIVATE)
        val ed = pref.edit()
        ed.putInt("spinner", selecte)
        ed.apply()
        f(selecte)

    }

    private fun f(selecte: Int) {

        TextView = findViewById<TextView>(R.id.num)
        var t: Int
        when (selecte) {
            0 -> {
                t = R.string.num1
            }

            1 -> {
                t = R.string.num2
            }

            2 -> {
                t = R.string.num3
            }

            3 -> {
                t = R.string.num4
            }

            4 -> {
                t = R.string.num5
            }

            else -> t = 0
        }
        TextView.setText(t)


    }

    fun next(view: View) {
            val intent = Intent(this, AddMessage::class.java)
            startActivity(intent)
        }
    }

