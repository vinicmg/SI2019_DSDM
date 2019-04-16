package br.edu.unisep.mymeeting

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.edu.unisep.mymeeting.model.entity.Topico
import kotlinx.android.synthetic.main.activity_novo_topico.*

class NovoTopicoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_topico)
    }

    fun salvar(v : View) {
        val t = Topico()

        t.titulo = txtTitulo.text.toString()
        t.conteudo = txtConteudo.text.toString()
        t.tempo = txtTempo.text.toString().toInt()

        setResult(Activity.RESULT_OK)
        finish()
    }

}
