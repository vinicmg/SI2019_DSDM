package br.edu.unisep.listacontatos.model.vo

import java.io.Serializable

data class ContatoVO (
    var nome : String,
    var email : String
) : Serializable {

}