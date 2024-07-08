@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.lab2.ASM1

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.lab2.ASM1.viewmodel.LoginViewModel
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme

class LoginActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Thiết lập nội dung cho hoạt động
        setContent {
            Lab2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    val loginViewModel = LoginViewModel(context)
                    LoginScreen(loginViewModel = loginViewModel)
                }
            }
        }
    }
}



    @Composable
fun LoginScreen(loginViewModel: LoginViewModel){
        val context = LocalContext.current
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val loginMessage by remember { loginViewModel.loginMessage }
        val loginSuccess by remember { loginViewModel.loginSuccess }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row (
            modifier = Modifier
                .padding(top = 47.dp, bottom = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
           verticalAlignment = Alignment.CenterVertically
        ){
            Box(modifier = Modifier
                .padding(end = 20.dp)
                .background(color = Color.Black, shape = RoundedCornerShape(2.dp))
                .height(1.dp)
                .width(105.dp)
            )
            Image(painterResource(id = R.drawable.img), contentDescription = "",
                modifier = Modifier
                    .size(93.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape));
            Box(modifier = Modifier
                .padding(start = 20.dp)
                .background(color = Color.Black, shape = RoundedCornerShape(2.dp))
                .height(1.dp)
                .width(105.dp)
            )
        }
        Text(text = "Hello!!!",
            modifier = Modifier
                .padding(top=1.dp, start = 20.dp),
            color = Color.Gray,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(text = "WELCOME BACK",
            modifier = Modifier
                .padding(top=5.dp,start = 20.dp),
            color = Color.Black,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
        Column(
            modifier = Modifier
                .padding(top = 15.dp)
                // .background(color = Color(0xFFFF0000))
                .width(390.dp)
                .height(447.dp)
                //.padding() // Thêm padding để làm cho nổi bật dễ nhìn hơn
                // .shadow(8.dp, shape = RoundedCornerShape(16.dp)) // Thêm hiệu ứng nổi bật
                .shadow(
                    10.dp, shape = RoundedCornerShape(15.dp),
                    spotColor = Color.Transparent
                )
        ) {
            Text(text = "Email",
                modifier = Modifier
                    .padding(top=55.dp, start = 25.dp),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp)

            TextField(value = email,
                onValueChange = {email=it},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(357.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                )

            )
            Text(text = "Password",
                modifier = Modifier
                    .padding(top=55.dp, start = 25.dp),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp)

            TextField(value = password,
                onValueChange = {password=it},
                modifier = Modifier
                    .padding(start = 20.dp)
                    .width(357.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                ),
                trailingIcon = {
                       // modifier = Modifier.padding(end = 8.dp) )
                    Image(painterResource(id = R.drawable.img_1), contentDescription = "",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(20.dp))
                },
            )
            Text(text = "Forgot Password",
                modifier = Modifier
                    .padding(top = 35.dp)
                    .align(CenterHorizontally),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp)
            Button(onClick = {   loginViewModel.loginUser(email, password)},
                modifier = Modifier
                    .padding(top = 14.dp)
                    .width(285.dp)
                    .align(CenterHorizontally)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                 containerColor = Color.Black,
                    contentColor = Color.White
                )

            ) {
                Text(text = "Log in")
            }
            Text(text = "SIGN UP",
                modifier = Modifier
                    .padding(top =14.dp)
                    .align(CenterHorizontally),
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight(600),
                fontSize = 14.sp)
        }

    }
        LaunchedEffect(loginSuccess) {
            if (loginSuccess) {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                // Navigate to the next screen or activity
                context.startActivity(Intent(context, demoActivity::class.java))
            } else if (loginMessage.isNotEmpty()) {
                Toast.makeText(context, loginMessage, Toast.LENGTH_SHORT).show()
            }
        }
}
@RequiresApi(Build.VERSION_CODES.R)
@Preview( showBackground = true)
@Composable
fun LoginPreview(){
    Lab2Theme {
        LoginScreen(loginViewModel = LoginViewModel(LocalContext.current))
    }
}