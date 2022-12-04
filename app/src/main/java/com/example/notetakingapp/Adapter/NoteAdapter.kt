package com.example.notetakingapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakingapp.Model.Note
import com.example.notetakingapp.R

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notes:List<Note> = ArrayList()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewTitle:TextView = itemView.findViewById(R.id.textView)
        val textViewDes:TextView = itemView.findViewById(R.id.textView2)
        val cardView:CardView = itemView.findViewById(R.id.cv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val view:View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_note_app,parent,false)
        return NoteViewHolder(view)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        var currNote:Note = notes[position]
        holder.textViewTitle.text = currNote.title
        holder.textViewDes.text = currNote.des

    }

    override fun getItemCount(): Int {
        return notes.size
    }
    fun setNote(myNotes:List<Note>){
        this.notes = myNotes
        notifyDataSetChanged()
    }
}