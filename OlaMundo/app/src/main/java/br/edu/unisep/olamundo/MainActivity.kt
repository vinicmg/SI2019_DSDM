package br.edu.unisep.olamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun exibirMensagem(v : View) {
        val nome = txtNome.text.toString()

        val t = Toast.makeText(this, "Olá $nome !!", Toast.LENGTH_LONG)
        t.show()
    }

}
