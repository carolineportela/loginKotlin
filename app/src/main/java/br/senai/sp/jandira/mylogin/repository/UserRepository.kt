package br.senai.sp.jandira.mylogin.repository

import android.content.Context
import br.senai.sp.jandira.mylogin.dao.TripDb
import br.senai.sp.jandira.mylogin.model.User

//aqui fica o repositorio do usuario
class UserRepository(context: Context) {

    //criando a instancia do banco
    private val db = TripDb.getDatabase(context)

    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    //achar um usuario no banco cm esse email
    fun findUserByEmail(email: String): User {
        return db.userDao().findUserByEmail(email)
    }

}