package com.example.guru02

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ToDoListActivity : AppCompatActivity() {

    private lateinit var todoList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var todoEdit: EditText
    private lateinit var changeBtn: Button
    private lateinit var deleteBtn: Button
    private lateinit var completeBtn: Button
    private lateinit var cancelBtn: Button

    var isCompl: Boolean = false
    var isCancel: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        //ArrayList 초기화
        todoList = ArrayList()

        //ArrayAdapter 초기화(context, layout, list)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, todoList)

        //UI객체 생성
        val listView: ListView = findViewById(R.id.list_view)
        val addBtn: Button = findViewById(R.id.add_btn)
        todoEdit = findViewById(R.id.todo_edit)
        changeBtn = findViewById(R.id.changeBtn)
        deleteBtn = findViewById(R.id.deleteBtn)
        completeBtn = findViewById(R.id.completeBtn)
        cancelBtn = findViewById(R.id.cancelBtn)

        //Adapter 적용
        listView.adapter = adapter

        listView.choiceMode = ListView.CHOICE_MODE_SINGLE

        //추가 버튼 이벤트
        addBtn.setOnClickListener {
            //할일 추가
            addItem()
        }

        changeBtn.setOnClickListener {
            //입력값 변수에 담기
            val todoStr: String = todoEdit.text.toString()
            val checked = listView.checkedItemPosition

            if(checked >=0 && checked < adapter.count){
                todoList[checked] = todoStr
                adapter.notifyDataSetChanged()
            }
            // 선택 초기화
            listView.clearChoices()
        }

        //삭제 버튼 이벤트
        deleteBtn.setOnClickListener {

            val checked = listView.checkedItemPosition

            if(checked >=0 && checked < adapter.count){
                todoList.removeAt(checked)
                adapter.notifyDataSetChanged()
            }
            // 선택 초기화
            listView.clearChoices()
        }

        //완료 버튼 이벤트
        completeBtn.setOnClickListener {

            isCompl = !isCompl

            if(isCompl)
            {
                Toast.makeText(this, "항목을 클릭하여 완료할 수 있습니다.", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "완료하기를 그만두려면 버튼을 한번 더 눌러주세요.", Toast.LENGTH_LONG).show()
            }
        }

        //완료 취소 버튼 이벤트
        cancelBtn.setOnClickListener {

            isCancel = !isCancel

            if(isCancel)
            {
                Toast.makeText(this, "완료된 항목을 클릭하여 취소할 수 있습니다.", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "취소하기를 그만두려면 버튼을 한번 더 눌러주세요.", Toast.LENGTH_LONG).show()
            }
        }

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val textView: TextView = view as TextView

            if(isCompl)
            {
                textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                // 선택 초기화
                listView.clearChoices()
            }
            if(isCancel)
            {
                textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                // 선택 초기화
                listView.clearChoices()
            }
        }
    } //onCreate


    private fun addItem(){

        //입력값 변수에 담기
        val todo: String = todoEdit.text.toString()

        //값이 비워있지 않다면
        if(todo.isNotEmpty()){
            //할일 추가
            todoList.add(todo)

            //적용
            adapter.notifyDataSetChanged()
        } else {
            Toast.makeText(this, "할 일을 적어주세요", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_home -> {
                val intent = Intent(this,CalendarActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}