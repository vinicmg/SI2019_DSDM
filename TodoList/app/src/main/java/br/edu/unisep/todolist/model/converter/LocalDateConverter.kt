package br.edu.unisep.todolist.model.converter

import android.arch.persistence.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object LocalDateConverter {

    private val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    @TypeConverter
    @JvmStatic
    fun stringToDate(valor : String?) : LocalDate? {
        return when (valor) {
            null -> null
            else -> LocalDate.parse(valor, dtf)
        }
    }


    @TypeConverter
    @JvmStatic
    fun dateToString(valor : LocalDate?) : String? {
        return when (valor) {
            null -> null
            else -> dtf.format(valor)
        }
    }
}