package com.example.lab2.ASM1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ASM1.viewmodel.CategoryViewModel
import com.example.lab2.ui.theme.Lab2Theme

class demoDMSPActivity : ComponentActivity() {
    private val categoryViewModel: CategoryViewModel by viewModels();
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
                    DMSPScreen()
                }
            }
        }
    }
}
    @Composable
    fun DMSPScreen() {

    }

    @RequiresApi(Build.VERSION_CODES.R)
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun DMSPPreview() {
        Lab2Theme {
            DMSPScreen()
        }
    }


