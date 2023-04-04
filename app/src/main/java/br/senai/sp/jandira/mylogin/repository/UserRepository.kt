package br.senai.sp.jandira.mylogin.repository

import android.content.Context
import br.senai.sp.jandira.mylogin.dao.TripDb
import br.senai.sp.jandira.mylogin.model.User

class UserRepository (context: Context){

    //criando a instancia do banco
    private val db = TripDb.getDatabase(context)

    fun save (user: User): Long{
        return db.userDao().save(user)
    }

}