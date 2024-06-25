package com.example.leaseorrenthomapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PersonInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_info)

        val fullNameEditText = findViewById<EditText>(R.id.fullNameEditText)
        val cardNumberEditText = findViewById<EditText>(R.id.editTxtCard)
        val favouriteSportEditText = findViewById<EditText>(R.id.favouriteSportEditText)
        val favouriteFoodEditText = findViewById<EditText>(R.id.favouriteFoodEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val cardNumber = cardNumberEditText.text.toString()
            val favouriteSport = favouriteSportEditText.text.toString()
            val favouriteFood = favouriteFoodEditText.text.toString()



            if (fullName.isEmpty() || cardNumber.isEmpty() || favouriteSport.isEmpty() || favouriteFood.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("UserDetails", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("FullName", fullName)
                    putString("CardNumber", cardNumber)
                    putString("FavouriteSport", favouriteSport)
                    putString("FavouriteFood", favouriteFood)
                    apply()
                }
                Toast.makeText(this, "Information saved successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Success::class.java)
                startActivity(intent)
            }
        }
    }
}
