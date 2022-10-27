package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.notes.databinding.ActivityAddNoteBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class AddNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding
    lateinit var editTitle: EditText
    lateinit var editText: EditText
    lateinit var buttonSave: Button
    lateinit var noteList: ArrayList<NotesData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        editTitle = findViewById(R.id.editTextTitle)
        editText = findViewById(R.id.editTextText)
        buttonSave = findViewById(R.id.buttonSave)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("notes", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPref.getString("notes", null)
        val type: Type = object : TypeToken<ArrayList<NotesData?>?>() {}.type
        //noteList = gson.fromJson<Any>(json, type) as ArrayList<NotesData>


        buttonSave.setOnClickListener {
            val sharedPref = getSharedPreferences("notes", MODE_PRIVATE)
            val editor = sharedPref.edit()
            val gson = Gson()
            val json: String = gson.toJson(noteList)
            editor.putString("notes", json)
            editor.apply()
            Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}