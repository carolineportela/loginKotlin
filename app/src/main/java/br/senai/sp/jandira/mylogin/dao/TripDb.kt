package br.senai.sp.jandira.mylogin.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.mylogin.model.User

//classe que representa o banco

//essa funcao e abstract - nao permite que outras classes a herdam
//funcao que retorna o nosso banco

//abaixo falando pro Room que essa classe representa o banco de dados
//entidades e versao do banco
@Database(entities = [User::class], version = 1)
abstract class TripDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        //inicializacao preguicosa - espera td ser concluido para instanciar
        private lateinit var instanceDb: TripDb


        fun getDatabase(context: Context): TripDb {
            //se a instancia estiver inicializada ele vai devolver o banco pra quem chamou
            if (!::instanceDb.isInitialized) {
                instanceDb = Room
                    .databaseBuilder(
                        context,
                        TripDb::class.java,
                        "db_trip"
                    ).allowMainThreadQueries().build()
            }
            return instanceDb
        }

    }
}