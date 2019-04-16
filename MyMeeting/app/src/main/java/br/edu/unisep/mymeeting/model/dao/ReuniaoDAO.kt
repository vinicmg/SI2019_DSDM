package br.edu.unisep.mymeeting.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.edu.unisep.mymeeting.model.entity.Reuniao

@Dao
interface ReuniaoDAO {

    @Insert
    fun salvar(r : Reuniao)

    @Query("select * from Reuniao")
    fun listar() : List<Reuniao>

}