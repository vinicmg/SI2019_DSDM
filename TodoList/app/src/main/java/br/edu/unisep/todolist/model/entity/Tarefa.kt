package br.edu.unisep.todolist.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import br.edu.unisep.todolist.model.converter.LocalDateConverter
import java.time.LocalDate

@Entity
@TypeConverters(LocalDateConverter::class)
data class Tarefa(@PrimaryKey(autoGenerate = true) var id : Int? = null) {

    var titulo : String? = null
    var descricao : String? = null
    var prioridade : Int? = null
    var data : LocalDate? = null
}