package br.edu.unisep.exemplonavegacao

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Tela2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
    }

    fun voltar(v : View) {
        finish()
    }

}
