package com.example.leaseorrenthomapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaymentMethod : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment_method)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radBtnCash = findViewById<RadioButton>(R.id.radCash)
        val radBtnCredit = findViewById<RadioButton>(R.id.radCredit)
        val radBtDebit = findViewById<RadioButton>(R.id.radDebit)
        val radGrpPay = findViewById<RadioGroup>(R.id.radGrpPayment)
        val btnNextPay = findViewById<Button>(R.id.btnPayment)
        radBtnCash.visibility = View.GONE

        btnNextPay.setOnClickListener {

            val intent = Intent(this, PersonInfo::class.java)

            startActivity(intent)
        }
    }
}