package br.edu.unisep.todolist

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.unisep.todolist.model.db.TodoListDB
import br.edu.unisep.todolist.model.entity.Tarefa
import kotlinx.android.synthetic.main.activity_nova_tarefa.*

class NovaTarefaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_tarefa)
    }

    fun salvar(v : View) {

        val tarefa = Tarefa()
        tarefa.titulo = txtTitulo.text.toString()
        tarefa.descricao = txtDesc.text.toString()

        tarefa.prioridade = when (gpPrioridade.checkedRadioButtonId) {
            R.id.rdBaixa -> 1
            R.id.rdMedia -> 2
            else -> 3
        }

    }

}
