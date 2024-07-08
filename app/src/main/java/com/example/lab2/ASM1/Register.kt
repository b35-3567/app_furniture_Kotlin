@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.lab2.ASM1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.ASM1.viewmodel.RegisterViewModel
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme

class RegisterActivity : ComponentActivity() {
    private val registerViewModel: RegisterViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    RegisterScreen(registerViewModel)
                }
            }
        }
    }


}

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }
    val registrationMessage by remember { registerViewModel.registrationMessage }
    val registrationSuccess by remember { registerViewModel.registrationSuccess }

    // Observe registration success and navigate accordingly
    LaunchedEffect(registrationSuccess) {
        if (registrationSuccess) {
            val intent = Intent(context, LoginActivity::class.java) // Replace NextActivity with your destination activity
            context.startActivity(intent)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 27.dp, bottom = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .background(color = Color.Black, shape = RoundedCornerShape(2.dp))
                    .height(1.dp)
                    .width(105.dp)
            )
            Image(
                painterResource(id = R.drawable.img), contentDescription = "",
                modifier = Modifier
                    .size(93.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape)
            )
            Box(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .background(color = Color.Black, shape = RoundedCornerShape(2.dp))
                    .height(1.dp)
                    .width(105.dp)
            )
        }
        Text(
            text = "WELCOME",
            modifier = Modifier
                .padding(top = 1.dp, start = 20.dp),
            color = Color.Black,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                .width(345.dp)
                .height(590.dp)
                .shadow(
                    20.dp, shape = RoundedCornerShape(10.dp),
                    spotColor = Color.Transparent
                )
        ) {
            Text(
                text = "Name",
                modifier = Modifier
                    .padding(top = 55.dp, start = 25.dp),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            TextField(
                value = fullname,
                onValueChange = {fullname=it},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(50.dp)
                    .width(315.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                )
            )
            Text(
                text = "Email",
                modifier = Modifier
                    .padding(top = 30.dp, start = 25.dp),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            TextField(
                value = email,
                onValueChange = {email=it},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(50.dp)
                    .width(315.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                )
            )
            Text(
                text = "Password",
                modifier = Modifier
                    .padding(top = 30.dp, start = 25.dp),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            TextField(
                value = password,
                onValueChange = {password=it},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(50.dp)
                    .width(315.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                ),
                trailingIcon = {
                    Image(
                        painterResource(id = R.drawable.img_1), contentDescription = "",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(20.dp)
                    )
                },
            )
            Text(
                text = "Confirm Password",
                modifier = Modifier
                    .padding(top = 30.dp, start = 25.dp),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .height(50.dp)
                    .width(315.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                ),
                trailingIcon = {
                    Image(
                        painterResource(id = R.drawable.img_1), contentDescription = "",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(20.dp)
                    )
                },
            )
            Button(
                onClick = {   registerViewModel.registerUser(email, password, fullname) },
                modifier = Modifier
                    .padding(top = 24.dp)
                    .width(285.dp)
                    .align(CenterHorizontally)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "SIGN UP")
            }
            if (registrationMessage.isNotEmpty()) {
                Toast.makeText(context, registrationMessage, Toast.LENGTH_SHORT).show()
            }
            Text(
                text = buildAnnotatedString {
                    append("Already have account?")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    ) {
                        append("SIGN IN")
                    }
                },
                fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B6D7B),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable{
                        val intent = Intent(context, LoginActivity::class.java) // Replace NextActivity with your destination activity
                        context.startActivity(intent)
                    }

            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab2Theme {
        val viewModel = RegisterViewModel()
        RegisterScreen(viewModel)
    }
}
