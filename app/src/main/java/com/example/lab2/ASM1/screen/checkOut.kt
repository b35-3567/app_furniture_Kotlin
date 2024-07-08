package com.example.lab2.ASM1.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme

@Composable
fun checkOutScreen() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
//                .background(color = Color.Blue),
            horizontalArrangement = Arrangement.spacedBy(33.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(0.dp))
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(color = Color.White),

                ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back Icon"
                )
            }
            Spacer(modifier = Modifier.width(35.dp))
            Text(
                text = "Check out",
                modifier = Modifier
                    .height(29.dp),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 60.sp
                )
            )
        }
        Row(
            modifier = Modifier
                .padding(start = 21.dp, top = 19.dp)
                .fillMaxWidth(),
//                .background(color = Color.Blue),
            horizontalArrangement = Arrangement.spacedBy(33.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
                Text(
                    text = "Shipping Address",
                    modifier = Modifier
                        .width(146.dp)
                        .height(29.dp),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 60.sp
                    ),
                    color = Color.Gray
                )

            Spacer(modifier = Modifier.width(120.dp))
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Back Icon"
            )
        }
        Card (
            modifier = Modifier
                .padding(start = 30.dp, top = 15.dp)
                .width(335.dp)
                .height(127.dp),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
               containerColor = Color.White,

                )
        ){

            Column {
                Text(text = "Bruno Fernandes",
                    modifier = Modifier
                        .width(182.dp)
                        .height(50.dp)
                        .padding(15.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal
                )
                Box(
                    modifier = Modifier
                        .width(335.dp)
                        .height(2.dp)
                        .background(color = Color(0xFFF0F0F0)) // Màu nền của đường thẳng
                )
                Text(text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                    modifier = Modifier
                        .width(296.dp)
                        .height(50.dp)
                        .padding(15.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                    lineHeight = 25.sp
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(start = 21.dp, top = 19.dp)
                .fillMaxWidth(),
//                .background(color = Color.Blue),
            horizontalArrangement = Arrangement.spacedBy(33.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Payment",
                modifier = Modifier
                    .width(146.dp)
                    .height(29.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 60.sp
                ),
                color = Color.Gray
            )

            Spacer(modifier = Modifier.width(120.dp))
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Back Icon"
            )
        }
        Card (
            modifier = Modifier
                .padding(start = 30.dp, top = 15.dp)
                .width(335.dp)
                .height(68.dp),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,

                ),
        ){
            Row (
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(16.dp)
            ){
                Card(modifier = Modifier
                    .width(64.dp)
                    .height(38.dp),
                    elevation =  CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,

                        ),

                ){

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_14),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(32.dp)
                                    .height(25.dp)
                            )

                        }
                    }
                Spacer(modifier = Modifier
                    .width(17.dp))
                Text(text = "**** **** **** 3947")

                }
                }
        Row(
            modifier = Modifier
                .padding(start = 21.dp, top = 19.dp)
                .fillMaxWidth(),
//                .background(color = Color.Blue),
            horizontalArrangement = Arrangement.spacedBy(33.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Shipping Address",
                modifier = Modifier
                    .width(146.dp)
                    .height(29.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 60.sp
                ),
                color = Color.Gray
            )

            Spacer(modifier = Modifier.width(120.dp))
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Back Icon"
            )
        }
        Card (
            modifier = Modifier
                .padding(start = 30.dp, top = 15.dp)
                .width(335.dp)
                .height(54.dp),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,

                ),
        ){
            Image(
                painter = painterResource(id = R.drawable.dhl),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize() ,
                contentScale = ContentScale.Crop

            )
        }
        Spacer(modifier = Modifier
            .height(50.dp))
        Card (
            modifier = Modifier
                .padding(start = 30.dp, top = 15.dp)
                .width(335.dp)
                .height(155.dp),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,

                ),
        ){
            Row(modifier = Modifier
              //  .padding(horizontal = 16.dp)
                .background(color = Color(0xFFF8F5F5))
                .width(335.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Order: ",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(71.dp)
                        .height(27.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier
                    .weight(0.5f))
                Text(text = "$95.00",
                    modifier = Modifier
                        .padding(top = 11.dp, bottom = 11.dp)
                        .width(71.dp)
                        .height(27.dp),
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp)
            }
            Box(
                modifier = Modifier
                    .width(335.dp)
                    .height(2.dp)
                    .background(color = Color(0xFFF0F0F0)) // Màu nền của đường thẳng
            )
            Row(modifier = Modifier
                //  .padding(horizontal = 16.dp)
                .background(color = Color(0xFFF8F5F5))
                .width(335.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Order: ",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(71.dp)
                        .height(27.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier
                    .weight(0.5f))
                Text(text = "$95.00",
                    modifier = Modifier
                        .padding(top = 11.dp, bottom = 11.dp)
                        .width(71.dp)
                        .height(27.dp),
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp)
            }
            Box(
                modifier = Modifier
                    .width(335.dp)
                    .height(2.dp)
                    .background(color = Color(0xFFF0F0F0)) // Màu nền của đường thẳng
            )
            Row(modifier = Modifier
                //  .padding(horizontal = 16.dp)
                .background(color = Color(0xFFF8F5F5))
                .width(335.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Order: ",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(71.dp)
                        .height(27.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier
                    .weight(0.5f))
                Text(text = "$95.00",
                    modifier = Modifier
                        .padding(top = 11.dp, bottom = 11.dp)
                        .width(71.dp)
                        .height(27.dp),
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Normal,
                    fontSize = 20.sp)
            }
            Box(
                modifier = Modifier
                    .width(335.dp)
                    .height(2.dp)
                    .background(color = Color(0xFFF0F0F0)) // Màu nền của đường thẳng
            )


        }
        Spacer(modifier = Modifier
            .weight(1.0f))
        Card(modifier = Modifier
            .padding(start = 30.dp)
            .width(335.dp)
            .height(59.dp),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF242424),

                )) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "SUBMIT ORDER", color = Color.White)
            }
        }
            }
        }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun checkOutScreenPreview() {
    Lab2Theme {
        checkOutScreen()
    }
}