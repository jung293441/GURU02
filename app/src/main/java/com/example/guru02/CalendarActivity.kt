package com.example.guru02

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class CalendarActivity : AppCompatActivity() {
        var userID: String = "userID"
        lateinit var fname: String
        lateinit var str: String
        lateinit var calendarView: CalendarView
        lateinit var calendarTextView: TextView
        lateinit var title: TextView
        lateinit var plusBtn : Button
        lateinit var editTextMemo : EditText


        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_calendar)

            // UI값 생성
            calendarView=findViewById(R.id.calendarView)
            calendarTextView=findViewById(R.id.calendarTextView)
            title=findViewById(R.id.title)
            plusBtn = findViewById(R.id.plusBtn)
            editTextMemo = findViewById(R.id.editTextMemo)

            title.text = "달력 일기장"

            calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
                calendarTextView.visibility = View.VISIBLE
                plusBtn.visibility = View.VISIBLE
                calendarTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
                //checkDay(year, month, dayOfMonth, userID)
            }

            val intent = Intent(this, ToDoList::class.java)
            var plusBtn = findViewById<Button>(R.id.plusBtn)

            plusBtn.setOnClickListener{
                startActivity(intent)

            }

        }

    }