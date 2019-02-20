package br.edu.unisep.olamundo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun exibirMensagem(v : View) {
        val t = Toast.makeText(this, "Olá Mundo!!!", Toast.LENGTH_LONG)
        t.show()
    }

}
