package com.example.notes

import android.content.Context.MODE_PRIVATE
import android.media.Image
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.ActivityMainBinding

class RecyclerAdapter(private var noteList: ArrayList <NotesData>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder> () {


    private var images = intArrayOf(R.drawable.notes_icon)

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.note_layout, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.noteTitle.text = noteList.get(position).noteTitle
        holder.noteText.text = noteList.get(position).noteText
        holder.noteImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    inner class ViewHolder(NoteView: View): RecyclerView.ViewHolder(NoteView) {
        var noteImage: ImageView
        var noteTitle: TextView
        var noteText: TextView
        var noteDelete: Button
        val sharedPref = itemView.context.getSharedPreferences("notes", MODE_PRIVATE)

        init {
            noteImage = NoteView.findViewById(R.id.note_image)
            noteTitle = NoteView.findViewById(R.id.note_title)
            noteText = NoteView.findViewById(R.id.note_text)
            noteDelete = NoteView.findViewById(R.id.note_delete)

            sharedPref.getString("title", null)
            sharedPref.getString("note", null)
        }
    }
}