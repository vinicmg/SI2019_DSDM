package br.edu.unisep.listacontatos.adapter

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import br.edu.unisep.listacontatos.R
import br.edu.unisep.listacontatos.model.vo.ContatoVO

class ContatoAdapter(val dados : ArrayList<ContatoVO>) : RecyclerView.Adapter<ContatoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ContatoViewHolder {
        // Cria um objeto LayoutInflater, que é responsável por carregar o layout xml
        // do item da lista e transformá-lo em um objeto Kotlin
        val inflater = LayoutInflater.from(parent.context)

        // Carrega, a partir do XML, um objeto View que representa um item da lista de contatos
        val view = inflater.inflate(R.layout.item_contato, parent, false)

        // Cria o objeto ViewHolder, enviando como parâmetro o objeto gerado a partir do XML
        // do layout do item
        val holder = ContatoViewHolder(view)

        return holder

        // Todas as linhas acima tem o mesmo efeito que essa linha abaixo:
        //return ContatoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false))
    }

    override fun getItemCount(): Int {
        return dados.size
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, pos: Int) {
        // Obtém o objeto da lista de contatos, correspondente ao item a ser gerado
        val contato = dados[pos]

        // Chama o método do view holder responsável por valorizar os componentes do item
        // do RecyclerView com as informações do objeto ContatoVO
        holder.bind(contato)
    }


}