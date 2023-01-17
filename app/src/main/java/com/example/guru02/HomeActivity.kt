import android.annotation.SuppressLint
import java.io.FileInputStream
import java.io.FileOutputStream

import android.view.View
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.guru02.R


class HomeActivity : AppCompatActivity() {
    var userID: String = "userID"
    lateinit var fname: String
    lateinit var str: String
    lateinit var calendarView: CalendarView
    lateinit var calendarTextView: TextView
    lateinit var title:TextView
    lateinit var plusBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // UI값 생성
        calendarView=findViewById(R.id.calendarView)
        calendarTextView=findViewById(R.id.calendarTextView)
        title=findViewById(R.id.title)
        plusBtn = findViewById(R.id.plusBtn)

        title.text = "달력 일기장"

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendarTextView.visibility = View.VISIBLE
            plusBtn.visibility = View.VISIBLE
            calendarTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            //checkDay(year, month, dayOfMonth, userID)
        }

    }

}