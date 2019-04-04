package br.edu.unisep.todolist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.unisep.todolist.R
import br.edu.unisep.todolist.model.entity.Tarefa
import kotlinx.android.synthetic.main.item_tarefa.view.*

class TarefaAdapter(val tarefas : List<Tarefa>)
    : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): TarefaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_tarefa, parent, false)

        return TarefaViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, pos: Int) {
        val t = tarefas[pos]

        holder.itemView.lblTitulo.text = t.titulo
        holder.itemView.lblDescricao.text = t.descricao
    }


    class TarefaViewHolder(val v : View) : RecyclerView.ViewHolder(v)

}