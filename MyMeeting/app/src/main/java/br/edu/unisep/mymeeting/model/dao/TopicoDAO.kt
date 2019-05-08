package br.edu.unisep.mymeeting.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.edu.unisep.mymeeting.model.entity.Topico

@Dao
interface TopicoDAO {

    @Insert
    fun salvar(t : Topico)

    @Query("select * from Topico where reuniao = :idReuniao")
    fun listar(idReuniao : Int) : List<Topico>

}