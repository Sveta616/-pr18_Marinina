package com.example.pr18

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class ResultShow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_show)
        val v = intent.getStringExtra("res")
        val info = Gson().fromJson<Numbers>(v, object : TypeToken<Numbers>() {}.type)
        findViewById<TextView>(R.id.t3).text = info.message


        }
    }


