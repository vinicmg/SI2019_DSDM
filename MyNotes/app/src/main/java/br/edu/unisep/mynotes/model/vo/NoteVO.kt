package br.edu.unisep.mynotes.model.vo

import java.time.LocalDate

data class NoteVO(var id : String?,
                  var titulo : String?,
                  var conteudo : String?,
                  var data : LocalDate?) {

}