package br.edu.unisep.vendapizzas

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.unisep.vendapizzas.model.db.db_pizza
import br.edu.unisep.vendapizzas.model.entity.pedido
import kotlinx.android.synthetic.main.activity_nova_venda.*



class NovaVendaActivity : AppCompatActivity() {

    private var cliente : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_venda)

        cliente = intent.getIntExtra("cliente", -1)
    }


    fun salvar(v: View) {
        val t = pedido()

        t.nomeCliente = cliente
        t.email = txtEmail.text.toString()
        t.telefone = txtTelefone.text.toString()
        t.qtdCalabresa =  txtCalabresa.text.toDouble() * 25.00
        t.qtdFrango =   txtFrango.text.toDouble() * 20.00
        t.qtdModa =   txtModa.text.toDouble() * 18.00
        t.qtdPortuguesa =   txtPortuguesa.text.toDouble() * 16.00


        t.stauts = when (gpFormaPagto.checkedRadioButtonId) {

        }

        val dao = db_pizza.getDb(applicationContext).pedidoDAO()
        dao.salvar(t)

        setResult(Activity.RESULT_OK)
        finish()
    }
}
