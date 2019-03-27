package br.edu.unisep.listacontatos.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import br.edu.unisep.listacontatos.model.vo.ContatoVO
import kotlinx.android.synthetic.main.item_contato.view.*

class ContatoViewHolder(v : View, val fnExcluir : (ContatoVO) -> Unit) : RecyclerView.ViewHolder(v){

    fun bind(contato : ContatoVO) {

        // A variável itemView representa o item da lista.
        // Dentro do item, temos os componentes visuais que foram criados no layout do XML
        // Atribui-se, então, a cada componente do item, o seu respectivo valor a partir
        // dos atributos do objeto contato, recebido como parâmetro neste método
        itemView.lblNome.text = contato.nome
        itemView.lblEmail.text = contato.email

        // Define um listener para o evento de click do botão excluir do item
        // Ao clicar no botão excluir, será executada a função fnExcluir, recebida
        // como parâmetro a partir do Adapter
        itemView.btnExcluir.setOnClickListener {
            fnExcluir(contato)
        }
    }

}