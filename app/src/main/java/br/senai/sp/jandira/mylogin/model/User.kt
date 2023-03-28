package br.senai.sp.jandira.mylogin.model

import androidx.room.Entity


@Entity
data class User(
    var id: Long = 0,
    var userName: String = "",
    var phone: String = "",
    var email: String = "",
    var password: String = "",
    var isOver18: Boolean = false

)
