package com.example.lab2.ASM1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab2.ASM1.screen.HomeScreen
import com.example.lab2.ui.theme.Lab2Theme


class demoActivity : ComponentActivity() {
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
                    bottomNavDemo()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomNavDemo(){
    var selectedItem by remember {
        mutableStateOf("home")
    }
    val navController = rememberNavController()
    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                 //  .background(MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp))
            ) {
                //  IncludeContent.getListingContent()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen() }
                    composable("room") { RoomScreen() }
                }
            }
        },

        bottomBar = {
            NavigationBar(    containerColor = Color(0xFFFFFFFF) ){
                NavigationBarItem(selected = selectedItem=="home",
                    onClick = { selectedItem="home"
                        navController.navigate("home")},
                    label = { Text(text = "Home")},
                    icon = {   androidx.compose.material.Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Search Icon",
                        tint = if (selectedItem == "home") Color.Black else Color.Gray
                    )
                    })
                NavigationBarItem(selected = selectedItem=="Room",
                    onClick = { selectedItem="Room"
                        navController.navigate("room")
                    },
                    label = { Text(text = "Room")},
                    icon = {  androidx.compose.material.Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = "Search Icon",
                      //  tint = if (selectedItem == "home") Color.Black else Color.Gray
                    )  })
                NavigationBarItem(selected = selectedItem=="Room",
                    onClick = { selectedItem="Room"
                        navController.navigate("room")
                    },
                    label = { Text(text = "Notification")},
                    icon = {  androidx.compose.material.Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Search Icon",
                        //  tint = if (selectedItem == "home") Color.Black else Color.Gray
                    )  })
                NavigationBarItem(selected = selectedItem=="Room",
                    onClick = { selectedItem="Room"
                        navController.navigate("room")
                    },
                    label = { Text(text = "Admin")},
                    icon = {  androidx.compose.material.Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Search Icon",
                        //  tint = if (selectedItem == "home") Color.Black else Color.Gray
                    )  })

            }
        }

    )
}
@Composable
fun MailScreen(){
    Column {
        Text(text = "MAIL")
        Text(text = "MAIL")
    }
}
@Composable
fun RoomScreen(){
    Text(text = "ROOM")
}
@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true)
@Composable
fun demoPreview() {
    Lab2Theme {
        bottomNavDemo()
    }
}