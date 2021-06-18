package hu.postamario.mobilprogramozas.presentation

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.postamario.core.data.Note
import hu.postamario.mobilprogramozas.R
import kotlinx.android.synthetic.main.item_note.view.*
import kotlinx.android.synthetic.main.item_note.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NotesListAdapter(var notes: ArrayList<Note>, val actions: ListAction): RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>() {

    fun updatesNotes(newNotes: List<Note>)  {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
    )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    inner class NoteViewHolder(view: View): RecyclerView.ViewHolder(view)   {

        private val layout = view.noteLayout
        private val noteTitle = view.title
        private val noteContent = view.content
        private val noteDate = view.date
        private val noteWords = view.wordCount

        fun bind(note: Note)    {
            noteTitle.text = note.title
            noteContent.text = note.content

            val simpleDateFormat = SimpleDateFormat("yyyy.MMMdd., HH:mm:ss")
            val resultDate = Date(note.updateTime)
            noteDate.text = "Last updated: ${simpleDateFormat.format(resultDate)}"

            layout.setOnClickListener{ actions.onClick(note.id) }

            noteWords.text = "Number of words: ${note.wordCount}"
        }
    }

}
