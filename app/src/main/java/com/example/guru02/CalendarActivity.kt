package com.example.guru02

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CalendarActivity : AppCompatActivity() {
    lateinit var calendarView: CalendarView
    lateinit var calendarTextView: TextView
    lateinit var plusBtn: Button
    lateinit var editTextMemo: EditText
    lateinit var editMemoButtion: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        // UI값 생성
        calendarView = findViewById(R.id.calendarView)
        calendarTextView = findViewById(R.id.calendarTextView)
        plusBtn = findViewById(R.id.plusBtn)
        editTextMemo = findViewById(R.id.editTextMemo)
        editMemoButtion = findViewById(R.id.editMemoButtion)

        loadData()


        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendarTextView.visibility = View.VISIBLE
            plusBtn.visibility = View.VISIBLE
            calendarTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            //checkDay(year, month, dayOfMonth, userID)
        }

        val intent = Intent(this, ToDoListActivity::class.java)
        var plusBtn = findViewById<Button>(R.id.plusBtn)

        plusBtn.setOnClickListener {
            startActivity(intent)

        }

        editMemoButtion.setOnClickListener{
            saveData(editTextMemo.text.toString())
            var intent = Intent(this, CalendarActivity::class.java)
            intent.putExtra("memo", editTextMemo.text.toString())
            startActivity(intent)
        }

    }
    private fun saveData(memo:String){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putString("KEY_NAME", editTextMemo.text.toString()).apply()

    }
    private fun loadData(){
        var pref = this.getPreferences(0)
        var name = pref.getString("KEY_NAME", "")

        editTextMemo.setText(name.toString())
    }

}


