package br.senai.sp.jandira.mylogin.components

import android.os.UserManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopShape() {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        //backgroundColor = Brush.horizontalGradient(listOf(Color.Magenta, Color.Yellow)),
        shape = RoundedCornerShape(bottomStart = 16.dp)
    ) {
      Box(modifier = Modifier
          .background(
              brush = Brush.horizontalGradient(
                  listOf(
                      Color.Red,
                      Color.Green
                  )

              )
          )
      )
    }
}

@Preview
@Composable
fun TopShapePreview() {
    TopShape()
}

@Composable
fun BottomShape() {

    Card(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        backgroundColor = Color.Magenta,
        shape =RoundedCornerShape(0.dp, 15.dp, 0.dp, 0.dp)
    ){

    }


}

@Preview
@Composable
fun BottomShapePreview() {
    BottomShape()
}
