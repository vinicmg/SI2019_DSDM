package br.edu.unisep.todolist.model.dao

import android.arch.persistence.room.*
import br.edu.unisep.todolist.model.entity.Tarefa

@Dao
interface TarefaDAO {

    @Insert
    fun salvar(t : Tarefa)

    @Query("select * from Tarefa")
    fun listar() : List<Tarefa>

    @Update
    fun alterar(t : Tarefa)

    @Query("select * from Tarefa where id = :id")
    fun consultar(id : Int) : Tarefa

}