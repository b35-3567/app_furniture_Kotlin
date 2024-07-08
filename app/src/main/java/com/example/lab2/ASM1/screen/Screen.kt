package com.example.lab2.ASM1.screen

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.TRANSPARENT
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class ScreenActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.light(
                scrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT
            )
        )
        // Ensure the content fills the screen and is not obscured by system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Lab2Theme {
                TransparentSystemBars() // Set system bars to be transparent
                val systemUiController = rememberSystemUiController()
                val colorScheme = MaterialTheme.colorScheme

                // Đảm bảo icon trên thanh trạng thái là sáng hoặc tối dựa trên giao diện người dùng
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,

                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Screendemo()
                }
            }
        }

    }
}
@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        onDispose {}
    }
}
@Composable
fun Screendemo() {

/*
    Box(modifier = Modifier.fillMaxSize()) {
        // Image that covers the entire screen
        Image(
            painter = painterResource(id = R.drawable.bed_1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        // Column containing text content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Add padding for spacing from edges
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Other content on top of the image
            Text(
                text = "Monday, Jun 10",
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = "Monday, Jun 10",
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }



 */
    val emojis = (1..100)
        .map { String(Character.toChars(127744 + it)) }
        .toList()

    LazyColumn(
      contentPadding = WindowInsets.systemBars.asPaddingValues(),
            modifier = Modifier
                .padding(start = 34.dp)

    ) {
        items(emojis) {
            Text(
                it, modifier = Modifier
                    .padding(
                        vertical = 10.dp,
                        horizontal = 16.dp
                    )

                    .fillMaxWidth()
            )
        }
    }

}

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenDemoPreview() {
    Lab2Theme {
        Screendemo()
    }
}
