package br.edu.unisep.mynotes.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.unisep.mynotes.R
import br.edu.unisep.mynotes.model.vo.NoteVO
import kotlinx.android.synthetic.main.item_note.view.*
import java.time.format.DateTimeFormatter

class NotesAdapter(val notes : List<NoteVO>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val df = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.item_note, parent, false)

        return NoteViewHolder(item)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, pos: Int) {
        val n = notes[pos]

        with (viewHolder.itemView) {
            lblTitulo.text = n.titulo
            lblConteudo.text = n.conteudo
            lblData.text = df.format(n.data)
        }
    }


    class NoteViewHolder(v : View) : RecyclerView.ViewHolder(v)

}