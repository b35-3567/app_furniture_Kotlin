package com.example.lab2.ASM1.screen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme

class ManHinhCuoiActivity : ComponentActivity() {
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
                    ManHinhCuoiScreen()
                }
            }
        }
    }
}
@Composable
fun ManHinhCuoiScreen() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp, top = 80.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "SUCCESS!",
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            color = Color(android.graphics.Color.parseColor("#303030")),
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp)
                .height(254.dp)
                .width(269.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.babckgr),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.gr),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 24.dp, horizontal = 35.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomCenter),
            )
        }
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(android.graphics.Color.parseColor("#606060")),
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    ),
                ) {
                    append("Your order will be delivered soon.\n")
                }
            },
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 40.dp)
                .height(60.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(8.dp),
                    clip = true,
                    ambientColor = Color.Gray,
                    spotColor = Color.Black
                ),
            colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#242424"))),
            shape = RoundedCornerShape(4.dp),
        ) {
            Text(
                text = "Track your orders",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,

                )
        }
        Button(     onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 25.dp)
                .height(60.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp)),

            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(4.dp),
        ) {
            Text(
                text = "BACK TO HOME",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
    }

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ManHinhCuoiPreview() {
    Lab2Theme {
         ManHinhCuoiScreen()
    }
}