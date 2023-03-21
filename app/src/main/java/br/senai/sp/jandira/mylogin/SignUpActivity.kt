package br.senai.sp.jandira.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
                SignUp()

            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUp() {
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
                        .width(120.dp)
                        .height(40.dp), color = Color.Magenta,
                    shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 15.dp)
                ) {

                }
            }
            Spacer(modifier = Modifier.height(14.dp))

            //Form
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(17.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 32.sp,
                    color = Color.Magenta
                )
                Text(
                    text = "Create a new account",
                    fontSize = 14.sp,

                    )
                Spacer(modifier = Modifier.height(32.dp))

                OutlinedTextField(
                    value = "carolportela",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "Username") }
                )
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(
                    value = "9999-9999",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "Phone") }

                )
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(
                    value = "carol@gmail.com",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "E-mail") }

                )
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(
                    value = "*********",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "PassWord") }

                )
                Spacer(modifier = Modifier.height(21.dp))
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                    Row() {
                        Checkbox(checked = false, onCheckedChange = {}
                        )
                        Row(Modifier.padding(top = 14.dp)) {
                            Text(text = "Over 18?")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(23.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End,

                    ) {
                    Button(
                        onClick = {/*TODO*/ },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                    ) {
                        Text(text = "CREATE ACCOUNT")
                    }
                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                    Row() {
                        Text(text = "Already have an account?")
                        Row(modifier = Modifier.padding(start = 3.dp)) {
                            Text(text = "Sign in", color = Color.Magenta)
                        }
                    }
                }
            }


        }
    }
}