package com.example.lab2.ASM1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme


class DemoTActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoTScreen()
                }
            }
        }
    }
}

@Composable
fun DemoTScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(
            title = { Text("Product") },
            backgroundColor = Color.White,
            elevation = 0.dp
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProductImage()
        Spacer(modifier = Modifier.height(16.dp))
        ProductDetails()
    }
}

@Composable
fun ProductImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
         ColorOptions()
    }
}

@Composable
fun ColorOptions() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        com.example.lab2.ASM1.ColorOptionT(Color(0xFFD3C1A5))
        Spacer(modifier = Modifier.height(8.dp))
        com.example.lab2.ASM1.ColorOptionT(Color(0xFFEEE0C9))
    }
}

@Composable
fun ColorOptionT(color: Color) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(color, shape = CircleShape)
    )
}

@Composable
fun ProductDetails() {
    Column {
        Text(
            text = "Minimal Stand",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$50",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DemoTPreview() {
    Lab2Theme {
        DemoTScreen()
    }
}
