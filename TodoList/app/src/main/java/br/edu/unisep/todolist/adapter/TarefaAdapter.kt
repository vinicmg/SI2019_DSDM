package br.edu.unisep.todolist.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.unisep.todolist.R
import br.edu.unisep.todolist.model.converter.LocalDateConverter
import br.edu.unisep.todolist.model.entity.Tarefa
import kotlinx.android.synthetic.main.item_tarefa.view.*

class TarefaAdapter(val tarefas : List<Tarefa>, val fnSelecao : (Int) -> Unit)
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
        holder.itemView.lblData.text = LocalDateConverter.dateToString(t.data)

        var indicador = holder.itemView.imgIndicador.drawable as GradientDrawable
        indicador.setTint(when (t.prioridade) {
            1 -> Color.parseColor("#81c784")
            2 -> Color.parseColor("#ffb74d")
            else -> Color.parseColor("#e57373")
        })

        holder.itemView.setOnClickListener {
            fnSelecao(t.id!!)
        }
    }


    class TarefaViewHolder(val v : View) : RecyclerView.ViewHolder(v)

}