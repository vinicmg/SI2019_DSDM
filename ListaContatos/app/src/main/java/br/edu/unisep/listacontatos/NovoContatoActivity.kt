package br.edu.unisep.listacontatos

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.unisep.listacontatos.model.vo.ContatoVO
import kotlinx.android.synthetic.main.activity_novo_contato.*

class NovoContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_contato)
    }

    fun salvar(v : View) {
        val c = ContatoVO(txtNome.text.toString(),
                          txtEmail.text.toString())

        val i = Intent()
        i.putExtra("contato", c)

        setResult(Activity.RESULT_OK, i)
        finish()
    }

}
