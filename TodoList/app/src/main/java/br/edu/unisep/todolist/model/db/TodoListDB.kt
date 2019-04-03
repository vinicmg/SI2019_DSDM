package br.edu.unisep.todolist.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.edu.unisep.todolist.model.dao.TarefaDAO
import br.edu.unisep.todolist.model.entity.Tarefa

@Database(
    entities = arrayOf(Tarefa::class),
    version = 1
)
abstract class TodoListDB : RoomDatabase(){

    abstract fun tarefaDAO() : TarefaDAO

    companion object {

        private var db: TodoListDB? = null

        fun getDb(applicationContext: Context): TodoListDB {

            if (db == null) {
                db = Room.databaseBuilder(applicationContext, TodoListDB::class.java,
                    "db_todolist").allowMainThreadQueries().build()
            }

            return db!!
        }
    }

}