package br.edu.unisep.mymeeting

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.unisep.mymeeting.model.converter.LocalDateConverter
import br.edu.unisep.mymeeting.model.db.MyMeetingDB
import br.edu.unisep.mymeeting.model.entity.Reuniao
import kotlinx.android.synthetic.main.activity_nova_reuniao.*

class NovaReuniaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_reuniao)
    }

    fun salvar(v : View) {
        val reuniao = Reuniao()

        reuniao.titulo = txtTitulo.text.toString()
        reuniao.assunto = txtAssunto.text.toString()
        reuniao.data = LocalDateConverter.stringToDate(txtData.text.toString())

        val dao = MyMeetingDB.getDb(applicationContext).reuniaoDAO()
        dao.salvar(reuniao)

        setResult(Activity.RESULT_OK)
        finish()
    }
}
