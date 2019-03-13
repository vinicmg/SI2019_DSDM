package br.edu.unisep.exemplonavegacao

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tela3.*

class Tela3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela3)
    }

    fun enviar(v : View) {
        // Cria o objeto Intent, que será responsável por conter o retorno que será
        // enviado para a tela anterior
        val i = Intent()

        // Adiciona o valor do retorno, associando a chave "retorno"
        // Através desta chave, o valor poderá ser recuperado na tela anterior
        i.putExtra("retorno", txtRetorno.text.toString())

        // Define o código de retorno da tela e o objeto Intent que contém
        // os dados a serem retornados
        setResult(Activity.RESULT_OK, i)

        // Encerra a Activity
        finish()
    }

}
