package br.edu.unisep.mymeeting

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.edu.unisep.mymeeting.adapter.TopicoAdapter
import br.edu.unisep.mymeeting.model.dao.TopicoDAO
import br.edu.unisep.mymeeting.model.db.MyMeetingDB
import br.edu.unisep.mymeeting.model.entity.Reuniao
import br.edu.unisep.mymeeting.model.entity.Topico
import kotlinx.android.synthetic.main.activity_lista_topicos.*

class ListaTopicosActivity : AppCompatActivity() {

    private lateinit var dao : TopicoDAO
    private val topicos = arrayListOf<Topico>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_topicos)

        configurarLista()
        listar()

        btnAddTopico.setOnClickListener {
            val i = Intent(this, NovoTopicoActivity::class.java)
            startActivityForResult(i, 1)
        }
    }

    private fun configurarLista() {
        val db = MyMeetingDB.getDb(applicationContext)
        dao = db.topicoDAO()

        listaTopicos.layoutManager = LinearLayoutManager(this)
        listaTopicos.adapter = TopicoAdapter(topicos)
    }

    private fun listar() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        listar()
    }

}
