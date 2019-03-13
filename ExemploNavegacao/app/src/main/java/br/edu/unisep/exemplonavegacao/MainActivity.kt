package br.edu.unisep.exemplonavegacao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirTela2(v : View) {
        val i = Intent(this, Tela2Activity::class.java)
        startActivity(i)
    }

    fun abrirTela3(v : View) {
        val i = Intent(this, Tela3Activity::class.java)
        startActivityForResult(i, 1)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val ret = data?.getStringExtra("retorno")

        val t = Toast.makeText(this, ret, Toast.LENGTH_LONG)
        t.show()
    }

}
