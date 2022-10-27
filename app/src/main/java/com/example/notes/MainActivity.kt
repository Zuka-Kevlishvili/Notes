package com.example.notes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    private lateinit var addButton: Button
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var noteList: ArrayList<NotesData>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager

        val sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("courses", null)
        val type: Type = object : TypeToken<ArrayList<NotesData?>?>() {}.type
        //noteList = gson.fromJson<Any>(json, type) as ArrayList<NotesData>
        //adapter = RecyclerAdapter(noteList)
        recyclerView.adapter = adapter

        addButton = findViewById(R.id.buttonAdd)
        onClick()

    }

    private fun onClick() {
        addButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

}