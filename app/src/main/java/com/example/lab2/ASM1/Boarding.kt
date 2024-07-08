package com.example.lab2.ASM1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ASM1.screen.ProductSeenActivity
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme

class BoardingActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    BoardingScreen()
                }
            }
        }
    }
}

@Composable
fun BoardingScreen( ) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "MAKE YOUR",
                modifier = Modifier
                    .padding(top = 231.dp, start = 30.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                fontStyle = FontStyle.Normal,
                color = Color(0xFF606060)
            )
            Text(
                text = "HOME BEAUTIFUL",
                modifier = Modifier
                    .padding(top = 10.dp, start = 30.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                fontStyle = FontStyle.Normal,
                color = Color(0xFF303030)
            )
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                modifier = Modifier
                    .padding(top = 16.dp, start = 39.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle.Normal,
                color = Color(0xFF808080)
            )
            Button(
                onClick = {
                    // Tạo một Intent để điều hướng
                    val intent = Intent(context, RegisterActivity::class.java).apply {
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .padding(top = 208.dp)
                    .width(159.dp)
                    .align(Alignment.CenterHorizontally)
                    .height(54.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Get Started")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BoardingPreview() {
    Lab2Theme {
        BoardingScreen()
    }
}
