package br.senai.sp.jandira.mylogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.repository.UserRepository
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


    val context = LocalContext.current

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
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

                    value = emailState,
                    onValueChange = { emailState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "Email") }
                )
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(
                    value = passwordState,
                    onValueChange = { passwordState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation =
                    if (!passwordVisibilityState) PasswordVisualTransformation()
                    else
                        VisualTransformation.None,
                    label = { Text(text = "PassWord") },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibilityState = !passwordVisibilityState
                            }
                        ) {

                            Icon(
                                imageVector = if (passwordVisibilityState)
                                    Icons.Default.VisibilityOff
                                else
                                    Icons.Default.Visibility,
                                contentDescription = null
                            )
                        }

                    }

                )

                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End,

                    ) {
                    Button(
                        onClick = {
                            authenticate(emailState, passwordState, context)
                        },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .height(48.dp)
                            .width(134.dp),
                        colors = ButtonDefaults.buttonColors(Color(207, 6, 240))
                    ) {
                        Text(text = "SIGN IN")


                    }
                }
                Spacer(modifier = Modifier.height(31.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Dont have an account?")
                        Row(
                            modifier = Modifier.padding(start = 3.dp)
                        ) {
                            TextButton(onClick = {
                                var openSignUp = Intent(context, SignUpActivity::class.java)
                                context.startActivity(openSignUp)

                            }) {
                                Text(
                                    text = "Sign Up",
                                    color = Color(207, 6, 240)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        modifier = Modifier
                            .width(140.dp)
                            .height(50.dp), color = Color.Magenta,
                        shape = RoundedCornerShape(0.dp, 15.dp, 0.dp, 0.dp)
                    ) {

                    }
                }
            }


        }

    }

}

fun authenticate(
    email: String,
    password: String,
    context: Context
) {
    val userRepository = UserRepository(context)
    val user = userRepository.authenticate(
        email, password
    )
    //terceira tela
    if (user != null) {
        val openHomeActivity = Intent(context, MyTrips::class.java)
        context.startActivity(openHomeActivity)
    }
}
