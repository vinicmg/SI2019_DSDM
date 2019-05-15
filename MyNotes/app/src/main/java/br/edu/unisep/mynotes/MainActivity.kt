package br.edu.unisep.mynotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.edu.unisep.mynotes.adapter.NotesAdapter
import br.edu.unisep.mynotes.model.vo.NoteVO
import br.edu.unisep.mynotes.task.ListaNotesTask
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val notes = arrayListOf<NoteVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaNotes.layoutManager = LinearLayoutManager(this)
        listaNotes.adapter = NotesAdapter(notes)

        listar()
    }

    private fun listar() {
        val t = ListaNotesTask { result ->
            notes.clear()
            notes.addAll(result!!)

            listaNotes.adapter!!.notifyDataSetChanged()
        }

        t.execute()
    }

}
