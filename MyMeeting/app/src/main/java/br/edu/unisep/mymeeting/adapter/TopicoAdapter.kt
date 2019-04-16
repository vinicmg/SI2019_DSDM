package br.edu.unisep.mymeeting.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.unisep.mymeeting.R
import br.edu.unisep.mymeeting.model.entity.Topico
import kotlinx.android.synthetic.main.item_topico.view.*

class TopicoAdapter(val topicos : List<Topico>) :
    RecyclerView.Adapter<TopicoAdapter.TopicoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): TopicoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_topico, parent,false)

        return TopicoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return topicos.size
    }

    override fun onBindViewHolder(holder: TopicoViewHolder, pos: Int) {
        val t = topicos[pos]

        with (holder.itemView) {
            lblTitulo.text = t.titulo
            lblConteudo.text = t.conteudo
            lblTempo.text = "${t.tempo} min"
        }
    }

    class TopicoViewHolder(v : View) : RecyclerView.ViewHolder(v)

}