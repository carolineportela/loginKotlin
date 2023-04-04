package br.senai.sp.jandira.mylogin.dao

import androidx.room.*
import br.senai.sp.jandira.mylogin.model.User

//Ess classe Interface é aonde fica as "condicoes" do contrato
@Dao
interface UserDao {
    //salvar,atualizar e deletar o usuario no banco de dados

    //salvar
    //long é do ID
    @Insert
    fun save(user: User): Long

    //atualizar
    @Update
    fun update(user: User): Int

    //deletar
    @Delete
    fun delete(user: User): Int

    //funcao para buscar usuario que esta se cadastrando pelo email no banco
    //se o e-mail nao estiver cadastrado,cria-se um novo usuario
    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: String): User
}