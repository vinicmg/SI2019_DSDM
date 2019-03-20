package br.edu.unisep.listacontatos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.edu.unisep.listacontatos.adapter.ContatoAdapter
import br.edu.unisep.listacontatos.model.vo.ContatoVO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val contatos : ArrayList<ContatoVO> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            adicionar()
        }

        // Define que o layout do RecyclerView será linear, ou seja, que os
        // itens adicionados à lista serão exibidos um abaixo do outro, na forma de lista
        listaContatos.layoutManager = LinearLayoutManager(this)

        // Cria um objeto ContatosAdapter e associa ao RecyclerView.
        // Desta forma, os itens do RecyclerView serão gerados através deste adapter
        listaContatos.adapter = ContatoAdapter(contatos)

    }

    fun adicionar() {
        val i = Intent(this, NovoContatoActivity::class.java)
        startActivityForResult(i, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val cont = data?.getSerializableExtra("contato") as ContatoVO
        contatos.add(cont)

        // Notifica o adapter do RecyclerView que houve a inserção de um novo item
        // na lista. O adapter irá então gerar o item no RecyclerView para exibir para o usuário.
        listaContatos.adapter?.notifyItemInserted(contatos.size - 1)

        // Rola o scroll do RecyclerView até a posição do último item adicionado na lista
        listaContatos.scrollToPosition(contatos.size - 1)
    }

}
