package com.example.guru02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //시작하기 버튼 눌렀을 시
        val intent = Intent(this, CalendarActivity::class.java)
        var StartButton = findViewById<Button>(R.id.StartButton)

        StartButton.setOnClickListener {
            startActivity(intent)


        }
    }


}