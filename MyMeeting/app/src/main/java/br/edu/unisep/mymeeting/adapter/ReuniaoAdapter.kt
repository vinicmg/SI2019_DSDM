package br.edu.unisep.mymeeting.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.unisep.mymeeting.R
import br.edu.unisep.mymeeting.model.entity.Reuniao
import kotlinx.android.synthetic.main.item_reuniao.view.*

class ReuniaoAdapter(val reunioes : List<Reuniao>) :
    RecyclerView.Adapter<ReuniaoAdapter.ReuniaoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ReuniaoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_reuniao, parent,false)

        return ReuniaoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return reunioes.size
    }

    override fun onBindViewHolder(holder: ReuniaoViewHolder, pos: Int) {
        val r = reunioes[pos]

        with (holder.itemView) {
            lblReuniao.text = r.titulo
            lblAssunto.text = r.assunto
            lblDia.text = r.data!!.dayOfMonth.toString()
            lblMes.text = r.data!!.month.name
        }
    }

    class ReuniaoViewHolder(v : View) : RecyclerView.ViewHolder(v)

}