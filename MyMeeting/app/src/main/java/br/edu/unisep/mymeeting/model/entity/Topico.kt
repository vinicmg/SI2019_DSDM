package br.edu.unisep.mymeeting.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity
data class Topico (@PrimaryKey(autoGenerate = true) var id : Int? = null) {

    var titulo : String? = null
    var conteudo : String? = null
    var tempo : Int? = null

}