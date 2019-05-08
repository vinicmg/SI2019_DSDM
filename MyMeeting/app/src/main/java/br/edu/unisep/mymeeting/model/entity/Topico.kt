package br.edu.unisep.mymeeting.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Reuniao::class, // Classe da tabela a que se refere a chave estrangeira
            parentColumns = ["id"], // Atributo chave primária da tabela relacionada
            childColumns = ["reuniao"] // Atributo chave estrangeira nesta tabela
            )
    ]
)
data class Topico (@PrimaryKey(autoGenerate = true) var id : Int? = null) {

    var titulo : String? = null
    var conteudo : String? = null
    var tempo : Int? = null
    var reuniao : Int? = null
}