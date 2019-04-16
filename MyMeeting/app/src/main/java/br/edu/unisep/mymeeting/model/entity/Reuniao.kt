package br.edu.unisep.mymeeting.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import br.edu.unisep.mymeeting.model.converter.LocalDateConverter
import java.io.Serializable
import java.time.LocalDate

@Entity
@TypeConverters(LocalDateConverter::class)
data class Reuniao(@PrimaryKey(autoGenerate = true) var id : Int? = null) : Serializable{

    var titulo : String? = null
    var assunto : String? = null
    var data : LocalDate? = null

}