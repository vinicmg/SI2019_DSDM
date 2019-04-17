package br.edu.unisep.todolist

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.unisep.todolist.model.converter.LocalDateConverter
import br.edu.unisep.todolist.model.dao.TarefaDAO
import br.edu.unisep.todolist.model.db.TodoListDB
import br.edu.unisep.todolist.model.entity.Tarefa
import kotlinx.android.synthetic.main.activity_nova_tarefa.*

class NovaTarefaActivity : AppCompatActivity() {

    private lateinit var dao : TarefaDAO
    private lateinit var tarefa : Tarefa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_tarefa)

        dao = TodoListDB.getDb(applicationContext).tarefaDAO()

        val id = intent.getIntExtra("id_tarefa", -1)
        if (id != -1) {
            tarefa = dao.consultar(id)

            txtTitulo.setText(tarefa.titulo)
            txtDesc.setText(tarefa.descricao)
            txtData.setText(LocalDateConverter.dateToString(tarefa.data))

            if (tarefa.prioridade == 1) {
                gpPrioridade.check(R.id.rdBaixa)
            } else if (tarefa.prioridade == 2) {
                gpPrioridade.check(R.id.rdMedia)
            } else {
                gpPrioridade.check(R.id.rdAlta)
            }
        } else {
            tarefa = Tarefa()
        }
    }

    fun salvar(v : View) {

        tarefa.titulo = txtTitulo.text.toString()
        tarefa.descricao = txtDesc.text.toString()

        tarefa.prioridade = when (gpPrioridade.checkedRadioButtonId) {
            R.id.rdBaixa -> 1
            R.id.rdMedia -> 2
            else -> 3
        }

        tarefa.data = LocalDateConverter.stringToDate(txtData.text.toString())

        if (tarefa.id == null) {
            dao.salvar(tarefa)
        } else {
            dao.alterar(tarefa)
        }

        setResult(Activity.RESULT_OK)
        finish()
    }

}
