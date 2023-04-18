package br.senai.sp.jandira.mylogin

import android.content.ContentValues.TAG
import android.content.Context
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.model.User
import br.senai.sp.jandira.mylogin.repository.UserRepository
import br.senai.sp.jandira.mylogin.ui.theme.MyLoginTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


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
    var userNameState by rememberSaveable {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    var context = LocalContext.current

    //Obter foto na galeria de fotos
    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    //Criar o objeto que abrirá a galeria e retornara
    //a Uri da imagem selecionada
   //linha abaixo faz a integracao do app e a galeria
    val launcher = rememberLauncherForActivityResult(
        contract =  ActivityResultContracts.GetContent()
    ){
        photoUri = it
    }
    //Coil = pega a imagem e tras pra mim bonitinha
    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(photoUri).build()
    )

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
                    .weight(weight = 1f)
                    .verticalScroll(rememberScrollState())
                    .padding(17.dp),


                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 32.sp,
                    color = Color.Magenta
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Create a new account",
                    fontSize = 14.sp,

                    )
                Spacer(modifier = Modifier.height(14.dp))
                Box(
                    modifier = Modifier.size(100.dp)

                )
                {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .align(alignment = Alignment.TopEnd),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 1.dp,
                            Brush.horizontalGradient(
                                colors = listOf(Color.Magenta, Color.White)
                            )
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = null,
                            modifier = Modifier
                                .align(alignment = Alignment.BottomEnd)
                                .size(28.dp)
                                .clickable {
                                           launcher.launch("image/*")
                                }


                        )

                    }


                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .align(alignment = Alignment.BottomEnd)
                            .offset(x = 6.dp, y = 0.dp)
                            .size(28.dp),
                        colorFilter = ColorFilter.tint(color = Color.Magenta)

                    )
//                    Card(
//                        modifier = Modifier
//                            .size(50.dp)
//                            .align(alignment = Alignment.BottomStart)
//                            .offset(x = 50.dp, y = (10).dp),
//                        shape = CircleShape,
//                        backgroundColor = Color.Green
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Email,
//                            contentDescription = null
//                        )
//
//                    }

                }
                Spacer(modifier = Modifier.height(32.dp))

                OutlinedTextField(
                    value = userNameState,
                    onValueChange = { userNameState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { Text(text = "Username") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = phoneState,
                    onValueChange = { phoneState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Phone") }

                )
                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    value = emailState,
                    onValueChange = { emailState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = { Text(text = "E-mail") }

                )
                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    value = passwordState,
                    onValueChange = { passwordState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    label = { Text(text = "PassWord") }

                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                    Row() {
                        Checkbox(checked = over18State, onCheckedChange = { checked ->
                            over18State = checked
                        }

                        )
                        Row(Modifier.padding(top = 14.dp)) {
                            Text(text = "Over 18?")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End,

                    ) {
                    Button(
                        onClick = {
                            userSave(
                                context,
                                emailState,
                                userNameState,
                                phoneState,
                                passwordState,
                                over18State
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp),
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

fun userSave(
    context: Context,
    email: String,
    userName: String,
    phone: String,
    password: String,
    isOver: Boolean
) {
    val userRepository = UserRepository(context)

    //Recuperando no banco um usuario que
    //tenha o email informado
    var user = userRepository.findUserByEmail(email)

    // se  user for null,gravamos o
    //novo usuario , se nao avisamos que o
    //usuario ja existe.

    if (user == null) {
        val newUser = User(
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver
        )
        val id = userRepository.save(newUser)
        Toast.makeText(
            context,
            "User created #$id",
            Toast.LENGTH_LONG
        ).show()
    } else {
        Toast.makeText(
            context, "User already exists!!",
            Toast.LENGTH_SHORT
        ).show()
    }

}


