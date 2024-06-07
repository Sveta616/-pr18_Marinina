package com.example.pr18

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson

class AddMessage : AppCompatActivity() {
    private lateinit var r1 : RadioButton
    private lateinit var r2 : RadioButton
    private lateinit var r3 : RadioButton
    private lateinit var r4 : RadioButton
    private lateinit var r5 : RadioButton
   private lateinit var v: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_message)
        r1 = findViewById(R.id.p1)
        r2 = findViewById(R.id.p2)
        r3 = findViewById(R.id.p3)
        r4 = findViewById(R.id.p4)
        r5 = findViewById(R.id.p5)
        v= findViewById<EditText>(R.id.message)
    }
    @SuppressLint("SuspiciousIndentation")
    fun tores(view: View) {
        val selectValue = when{
            r1.isChecked -> 1
            r2.isChecked -> 2
            r3.isChecked -> 3
            r4.isChecked -> 4
            r5.isChecked -> 5
            else -> 0
    }
        val mes = v.text.toString()
        if (selectValue === 0 || mes=="")
    {           val alert = AlertDialog.Builder(this)
        .setTitle("Ошибка")
        .setMessage(getString(R.string.mess_neg))
        .setPositiveButton("OK", null)
        .create()
        .show()        }

    else {

            val m = Numbers(mes)
            val json = Gson().toJson(m)
            val intent = Intent(this, ResultShow::class.java)
            intent.putExtra("res", json)
            startActivity(intent)
    }
    }

}