package br.senai.sp.jandira.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.ui.theme.MyLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
                Login()

            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Login() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Surface(
                    modifier = Modifier
                        .width(140.dp)
                        .height(50.dp), color = Color.Magenta,
                    shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 15.dp)
                ) {

                }
            }
            Spacer(modifier = Modifier.height(164.dp))

            //Form
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(17.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 40.sp,
                    color = Color.Magenta
                )
                Text(
                    text = "Please sign ing to continue",
                    fontSize = 20.sp,

                    )
                Spacer(modifier = Modifier.height(32.dp))

                OutlinedTextField(
                    value = "carol@gmail.com",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "Email") }
                )
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(
                    value = "*********",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "PassWord") }

                )

                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End,

                    ) {
                    Button(
                        onClick = {/*TODO*/ },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .height(48.dp)
                            .width(134.dp),
                        colors = ButtonDefaults.buttonColors(Color(207,6,240))
                    ) {
                        Text(text = "SIGN IN")



                    }
                }

            }


        }

    }

}