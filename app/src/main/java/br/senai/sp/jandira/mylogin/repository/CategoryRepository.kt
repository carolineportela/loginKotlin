package br.senai.sp.jandira.mylogin.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mylogin.R
import br.senai.sp.jandira.mylogin.model.Category

class CategoryRepository {
    companion object{
        @Composable
        fun getCategories(): List<Category> {

            return listOf(
                Category(
                    id = 1,
                    name = "Montain",
                    icon = painterResource(id = R.drawable.montain)
                ),
                Category(
                    id = 2,
                    name = "Snow",
                    icon = painterResource(id = R.drawable.snow)
                ),
                Category(
                    id = 3,
                    name = "Beach",
                    icon = painterResource(id = R.drawable.beach)
                ),
                Category(
                    id = 3,
                    name = "Montain",
                    icon = painterResource(id = R.drawable.montain)
                )
            )

        }

    }
    }


