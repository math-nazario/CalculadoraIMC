package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc:Button = findViewById(R.id.button_calc)
        val edtHeight:EditText = findViewById(R.id.edittext_height)
        val edtWeight:EditText = findViewById(R.id.edittext_weight)

        btnCalc.setOnClickListener {
            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()
            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height:Float = heightStr.toFloat()
                val weight:Float = weightStr.toFloat()
                val heightFinal:Float = height * height
                val result:Float =weight/heightFinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}