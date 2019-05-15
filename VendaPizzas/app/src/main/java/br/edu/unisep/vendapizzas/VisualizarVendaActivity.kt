package br.edu.unisep.vendapizzas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import br.edu.unisep.vendapizzas.adapter.PedidoAdapter
import br.edu.unisep.vendapizzas.model.dao.pedidoDAO
import br.edu.unisep.vendapizzas.model.db.db_pizza
import br.edu.unisep.vendapizzas.model.entity.pedido
import kotlinx.android.synthetic.main.activity_main.*

class VisualizarVendaActivity : AppCompatActivity() {

    private lateinit var dao : pedidoDAO
    private val pedidos = arrayListOf<pedido>()
    private var cliente : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_venda)

        cliente = intent.getIntExtra("cliente", -1)

        val sep = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)


        configurarLista()
        listar()

    }

    private fun configurarLista() {
        val db = db_pizza.getDb(applicationContext)
        dao = db.pedidoDAO()

        listaVendas.layoutManager = LinearLayoutManager(this)
        listaVendas.adapter = PedidoAdapter(pedidos)
    }

    private fun listar() {
        val lst = dao.listar(cliente)

        pedidos.clear()
        pedidos.addAll(lst)

        listaVendas.adapter?.notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        listar()
    }


}
