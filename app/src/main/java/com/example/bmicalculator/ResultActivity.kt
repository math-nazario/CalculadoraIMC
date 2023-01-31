package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val resultTv = findViewById<TextView>(R.id.textview_result)
        val classificationTv = findViewById<TextView>(R.id.textview_classification)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        resultTv.text = result.toString()

        /* TABELA IMC
            MENOR QUE 18.5  	ABAIXO DO PESO
            ENTRE 18.5 E 24.9  	NORMAL
            ENTRE 25.0 E 29.9  	SOBREPESO - I
            ENTRE 30.0 E 39.9  	OBESIDADE - II
            MAIOR QUE 40.0 		OBESIDADE GRAVE - III */

        val classification = if (result <= 18.5f) {
            "Abaixo do peso"
        }
        else if (result in 18.5f..24.9f) {
            "Normal"
        }
        else if (result in 25.0f..29.9f) {
            "Sobrepeso - I"
        }
        else if (result in 30.0f..39.9f) {
            "Obesidade - II"
        }
        else {
            "Obesidade grave - III"
        }
        classificationTv.text = getString(R.string.message_classificacao, classification)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            finish()
            return super.onOptionsItemSelected(item)
    }
}