package br.edu.unisep.todolist.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.edu.unisep.todolist.model.entity.Tarefa

@Dao
interface TarefaDAO {

    @Insert
    fun salvar(t : Tarefa)

    @Query("select * from Tarefa")
    fun listar() : List<Tarefa>

    @Delete
    fun excluir(t : Tarefa)
}