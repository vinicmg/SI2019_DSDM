package br.edu.unisep.mymeeting.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.edu.unisep.mymeeting.model.dao.ReuniaoDAO
import br.edu.unisep.mymeeting.model.dao.TopicoDAO
import br.edu.unisep.mymeeting.model.entity.Reuniao
import br.edu.unisep.mymeeting.model.entity.Topico

@Database(
    entities = [Reuniao::class, Topico::class],
    version = 1
)
abstract class MyMeetingDB : RoomDatabase(){

    abstract fun topicoDAO() : TopicoDAO

    abstract fun reuniaoDAO() : ReuniaoDAO

    companion object {
        private var db: MyMeetingDB? = null

        fun getDb(applicationContext: Context): MyMeetingDB {

            if (db == null) {
                db = Room.databaseBuilder(applicationContext, MyMeetingDB::class.java,
                    "db_mymeeting").allowMainThreadQueries().build()
            }

            return db!!
        }
    }

}