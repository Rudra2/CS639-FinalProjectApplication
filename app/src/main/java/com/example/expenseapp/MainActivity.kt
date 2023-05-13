package com.example.expenseapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var submit=findViewById<Button>(R.id.submit)
        var accommodation=findViewById<EditText>(R.id.accommodation)
        var transportation=findViewById<EditText>(R.id.transportation)
        var food=findViewById<EditText>(R.id.food)
        var textbook=findViewById<EditText>(R.id.textbook)
        var travel=findViewById<EditText>(R.id.travel)
        var phone=findViewById<EditText>(R.id.phone)
        var entertainment=findViewById<EditText>(R.id.entertainment)

        // Open Graph activity and pass data of expense to Graph activity

        submit.setOnClickListener{
            val intent = Intent(this@MainActivity, GraphActivity::class.java)
            intent.putExtra("accommodation", accommodation.text.toString())
            intent.putExtra("transportation", transportation.text.toString())
            intent.putExtra("food", food.text.toString())
            intent.putExtra("textbook",textbook.text.toString())
            intent.putExtra("travel", travel.text.toString())
            intent.putExtra("phone", phone.text.toString())
            intent.putExtra("entertainment", entertainment.text.toString())
            startActivity(intent)
        }

    }
}