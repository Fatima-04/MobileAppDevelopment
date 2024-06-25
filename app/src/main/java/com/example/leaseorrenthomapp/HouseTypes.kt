package com.example.leaseorrenthomapp

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HouseTypes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_house_types)

        val radGrp = findViewById<RadioGroup>(R.id.radGroup)
        radGrp.setOnCheckedChangeListener { group, checkedId ->
            val intent = when (checkedId) {
                R.id.radAppart -> Intent(this, AvailableAppartment::class.java)
                R.id.radCondo -> Intent(this, Condominium::class.java)
                R.id.radDetachedHome -> Intent(this, DetachedHome::class.java)
                R.id.radSemi -> Intent(this, SemiDetachedHome::class.java)
                R.id.radTown -> Intent(this, Townhouse::class.java)
                else -> null
            }
            intent?.let {
                startActivity(it)
            }
        }
//
//        val radButtonA = findViewById<RadioButton>(R.id.radAppart)
//        radButtonA.setOnClickListener {
//            val intent = Intent(this, Appartment::class.java)
//            startActivity(intent)
//        }
//
//
//       val radButtonC = findViewById<RadioButton>(R.id.radCondo)
//        radButtonC.setOnClickListener {
//            val intent = Intent(this, Condominium::class.java)
//            startActivity(intent)
//        }

//        val radButtonD = findViewById<RadioButton>(R.id.radDetachedHome)
//        radButtonD.setOnClickListener {
//            val intent = Intent(this, Appartment::class.java)
//            startActivity(intent)
//        }
//
//        val radButtonS = findViewById<RadioButton>(R.id.radSemi)
//        radButtonS.setOnClickListener {
//            val intent = Intent(this, Appartment::class.java)
//            startActivity(intent)
//        }
//
//        val radButtonT = findViewById<RadioButton>(R.id.radTown)
//        radButtonT.setOnClickListener {
//            val intent = Intent(this, Appartment::class.java)
//            startActivity(intent)
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}