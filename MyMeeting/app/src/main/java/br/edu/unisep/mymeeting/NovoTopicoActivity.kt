package br.edu.unisep.mymeeting

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.edu.unisep.mymeeting.model.db.MyMeetingDB
import br.edu.unisep.mymeeting.model.entity.Topico
import kotlinx.android.synthetic.main.activity_novo_topico.*

class NovoTopicoActivity : AppCompatActivity() {

    private var reuniao : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_topico)

        reuniao = intent.getIntExtra("reuniao", -1)
    }

    fun salvar(v : View) {
        val t = Topico()

        t.titulo = txtTitulo.text.toString()
        t.conteudo = txtConteudo.text.toString()
        t.tempo = txtTempo.text.toString().toInt()
        t.reuniao = reuniao

        val dao = MyMeetingDB.getDb(applicationContext).topicoDAO()
        dao.salvar(t)

        setResult(Activity.RESULT_OK)
        finish()
    }

}
