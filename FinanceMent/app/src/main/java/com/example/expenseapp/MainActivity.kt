package com.example.expenseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var submit=findViewById<Button>(R.id.submit);
        var accommodation=findViewById<EditText>(R.id.accommodation);
        var transportation=findViewById<EditText>(R.id.transportation);
        var food=findViewById<EditText>(R.id.food);
        var textbook=findViewById<EditText>(R.id.textbook);
        var travel=findViewById<EditText>(R.id.travel);
        var phone=findViewById<EditText>(R.id.phone);
        var entertainment=findViewById<EditText>(R.id.entertainment);

        submit.setOnClickListener{

        }

    }
}