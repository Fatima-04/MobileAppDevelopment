package com.example.leaseorrenthomapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson

class Townhouse : AppCompatActivity() {

    val houseList = listOf(
        HouseItem(R.drawable.t1, "123 Main St ", "  $1M"),
        HouseItem(R.drawable.t2, "456 Elm St ", "  $2M"),
        HouseItem(R.drawable.t3, "789 Oak Ave ", "  $1.5M"),
        HouseItem(R.drawable.t4, "101 Pine Dr ", "  $3M"),
        HouseItem(R.drawable.t5, "222 Maple Ln ", "  $2.5M")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_townhouse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView = findViewById<ListView>(R.id.aList)
        val adapter3 = HouseAdapter(this, houseList)
        listView.adapter = adapter3
        listView.onItemClickListener =
            AdapterView.OnItemClickListener {
                    parent, view, position, id ->
                val selectedHouse = houseList[position]
                Toast.makeText(applicationContext,"Selected item" , Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SelectedItem::class.java)
                intent.putExtra("houseItem", Gson().toJson(selectedHouse))
                startActivity(intent)
            }
    }
}