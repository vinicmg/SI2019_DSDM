package br.edu.unisep.todolist.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Tarefa(@PrimaryKey(autoGenerate = true) var id : Int? = null) {

    var titulo : String? = null
    var descricao : String? = null
    var prioridade : Int? = null

}