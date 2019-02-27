package br.edu.unisep.calculadoranotas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(v : View) {
        val g1 = txtG1.text.toString().toDouble()
        val g2 = txtG2.text.toString().toDouble()

        val subG1 = 21 - (2 * g2)
        val subG2 = (21 - g1) / 2

        val df = DecimalFormat("#0.0")

        if (subG1 <= subG2) {
            lblNota.text = df.format(subG1)
            lblOpcao.text = "Sub G1"
        } else {
            lblNota.text = df.format(subG2)
            lblOpcao.text = "Sub G2"
        }
    }


    fun limpar(v : View) {
        txtG1.text.clear()
        txtG2.text.clear()

        lblNota.text = "0,0"
        lblOpcao.text = ""
    }
}
