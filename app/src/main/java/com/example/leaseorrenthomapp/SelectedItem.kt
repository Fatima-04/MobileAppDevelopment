package com.example.leaseorrenthomapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson

class SelectedItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selected_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val houseItemJson = intent.getStringExtra("houseItem")
        val selectedItem = Gson().fromJson(houseItemJson,HouseItem::class.java)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Address: ${selectedItem.address}, Price: ${selectedItem.price}"
        val imageViewSelected = findViewById<ImageView>(R.id.imageView2)
        imageViewSelected.setImageResource(selectedItem.imageResId)

        val checkOutButton = findViewById<Button>(R.id.chkoutBtn)
        checkOutButton.setOnClickListener {
            val intent = Intent(this, PaymentMethod::class.java )
            startActivity(intent)
        }


    }
}