package com.example.freeimage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class FullImageActivity : AppCompatActivity() {
//    lateinit var titleTextView: TextView
//    lateinit var createrTextView: TextView
//    lateinit var responsibleTextView: TextView
//    lateinit var startDateTextView: TextView
//    lateinit var endedDateTextView: TextView
//    lateinit var priorityTextView: TextView
//    lateinit var descriptionTextView: TextView
//    lateinit var statusTextView: TextView
//    lateinit var editBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

//        titleTextView = findViewById(R.id.tvTaskTitle)
//        createrTextView = findViewById(R.id.tvTaskCreater)
//        responsibleTextView = findViewById(R.id.tvTaskResponsible)
//        startDateTextView = findViewById(R.id.tvTaskStartDate)
//        endedDateTextView = findViewById(R.id.tvTaskEndDate)
//        priorityTextView = findViewById(R.id.tvTaskPriority)
//        descriptionTextView = findViewById(R.id.tvTaskDescription)
//        statusTextView = findViewById(R.id.tvTask_status)
//        editBtn = findViewById(R.id.btnEditTask)
//
//        titleTextView.text = intent.getStringExtra(MainActivity.EXTRA_TITLE)
//        createrTextView.text = intent.getStringExtra(MainActivity.EXTRA_CREATOR)
//        responsibleTextView.text = intent.getStringExtra(MainActivity.EXTRA_RESPONSIBLE)
//        startDateTextView.text = intent.getStringExtra(MainActivity.EXTRA_START_DATE)
//        endedDateTextView.text = intent.getStringExtra(MainActivity.EXTRA_ENDED_DATE)
//        priorityTextView.text = intent.getStringExtra(MainActivity.EXTRA_PRIORITY)
//        statusTextView.text = intent.getStringExtra(MainActivity.EXTRA_STATUS)
//        descriptionTextView.text = intent.getStringExtra(MainActivity.EXTRA_DESCRIPTION)
//
//        editBtn.setOnClickListener() {
//            editTask(intent)
//        }

    }

//    fun editTask(i: Intent) {
//        val intent = i.setClass(this, AddTaskActivity::class.java)
//        startActivityForResult(intent, SEARCH_ACTIVITY_REQUEST_CODE)
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }

    companion object {
        const val SEARCH_ACTIVITY_REQUEST_CODE = 2
    }
}