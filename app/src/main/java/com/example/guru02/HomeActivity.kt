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
    lateinit var updateBtn: Button
    lateinit var deleteBtn:Button
    lateinit var saveBtn:Button
    lateinit var calendarTextView: TextView
    lateinit var diaryContent:TextView
    lateinit var title:TextView
    lateinit var contextEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        // UI값 생성
        calendarView=findViewById(R.id.calendarView)
        calendarTextView=findViewById(R.id.calendarTextView)
        diaryContent=findViewById(R.id.diaryContent)
        title=findViewById(R.id.title)
        contextEditText=findViewById(R.id.contextEditText)

        title.text = "달력 일기장"

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendarTextView.visibility = View.VISIBLE
            saveBtn.visibility = View.VISIBLE
            contextEditText.visibility = View.VISIBLE
            diaryContent.visibility = View.INVISIBLE
            updateBtn.visibility = View.INVISIBLE
            deleteBtn.visibility = View.INVISIBLE
            calendarTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            contextEditText.setText("")
            //checkDay(year, month, dayOfMonth, userID)
        }

        saveBtn.setOnClickListener {
            //saveDiary(fname)
            contextEditText.visibility = View.INVISIBLE
            saveBtn.visibility = View.INVISIBLE
            updateBtn.visibility = View.VISIBLE
            deleteBtn.visibility = View.VISIBLE
            str = contextEditText.text.toString()
            diaryContent.text = str
            diaryContent.visibility = View.VISIBLE
        }
    }

}