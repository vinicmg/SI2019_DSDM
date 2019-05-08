package br.edu.unisep.mymeeting

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.edu.unisep.mymeeting.adapter.ReuniaoAdapter
import br.edu.unisep.mymeeting.model.dao.ReuniaoDAO
import br.edu.unisep.mymeeting.model.db.MyMeetingDB
import br.edu.unisep.mymeeting.model.entity.Reuniao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val reunioes = arrayListOf<Reuniao>()

    private lateinit var dao : ReuniaoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configurarLista()
        listar()

        btnAddReuniao.setOnClickListener {
            val i = Intent(this, NovaReuniaoActivity::class.java)
            startActivityForResult(i, 1)
        }
    }

    private fun configurarLista() {
        val db = MyMeetingDB.getDb(applicationContext)
        dao = db.reuniaoDAO()

        listaReunioes.layoutManager = LinearLayoutManager(this)
        listaReunioes.adapter = ReuniaoAdapter(reunioes, this::selecionarReuniao)
    }

    private fun listar() {
        var lst = dao.listar()

        reunioes.clear()
        reunioes.addAll(lst)

        listaReunioes.adapter?.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        listar()
    }

    fun selecionarReuniao(id : Int) {
        val i = Intent(this, ListaTopicosActivity::class.java)
        i.putExtra("reuniao", id)

        startActivityForResult(i, 2)
    }

}
