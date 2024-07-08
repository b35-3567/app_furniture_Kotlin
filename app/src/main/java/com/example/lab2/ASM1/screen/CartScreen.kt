package com.example.lab2.ASM1.screen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ASM1.RegisterScreen
import com.example.lab2.ASM1.viewmodel.RegisterViewModel
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme

class CartScreenActivity : ComponentActivity() {
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
                    CartScreen()
                }
            }
        }
    }


}
data class Items(val HinhSP: Int, val TenSP: String, val Price: Int,val Quanity :Int);
@Composable
fun CartScreen() {
    val context = LocalContext.current
    var data by remember {
        mutableStateOf(
            listOf(
                 Items(HinhSP = R.drawable.bed_1, TenSP = "MInal bed", Price = 125, Quanity = 23),
                 Items(HinhSP = R.drawable.bed_1, TenSP = "new bed", Price = 225, Quanity = 2),
                 Items(HinhSP = R.drawable.bed_1, TenSP = "hot bed", Price = 325, Quanity = 3),
                Items(HinhSP = R.drawable.bed_1, TenSP = "MInal bed", Price = 125, Quanity = 23),
                Items(HinhSP = R.drawable.bed_1, TenSP = "new bed", Price = 225, Quanity = 2),
                Items(HinhSP = R.drawable.bed_1, TenSP = "hot bed", Price = 325, Quanity = 3),
                Items(HinhSP = R.drawable.bed_1, TenSP = "MInal bed", Price = 125, Quanity = 23),
                Items(HinhSP = R.drawable.bed_1, TenSP = "new bed", Price = 225, Quanity = 2),
                Items(HinhSP = R.drawable.bed_1, TenSP = "hot bed", Price = 325, Quanity = 3),
                Items(HinhSP = R.drawable.bed_1, TenSP = "MInal bed", Price = 125, Quanity = 23),
                Items(HinhSP = R.drawable.bed_1, TenSP = "new bed", Price = 225, Quanity = 2),
                Items(HinhSP = R.drawable.bed_1, TenSP = "hot bed", Price = 325, Quanity = 3)


            )
        )
    }
   Box(
         // Dùng SpaceBetween để phân bố đều khoảng cách giữa các phần tử

    ) {
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
                    text = "My cart",
                    modifier = Modifier
                        .height(29.dp),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 60.sp
                    )
                )
            }


///////////////////////////////////////////////////

            LazyColumn(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
            ) {
                itemsIndexed(data) { index, item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp) // Padding cho Box để tạo khoảng cách trái và phải
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .clickable { },
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .width(334.dp)
                                    .height(100.dp)

                            ) {
                                Image(
                                    painter = painterResource(id = item.HinhSP),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .width(100.dp)
                                        .fillMaxHeight()
                                        .clip(
                                            shape = RoundedCornerShape(
                                                topStart = 15.dp,
                                                topEnd = 15.dp,
                                                bottomEnd = 15.dp,
                                                bottomStart = 15.dp
                                            )
                                        ),
                                    contentScale = ContentScale.Crop // Đặt contentScale để cắt bớt phần thừa
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(20.dp)
                                )
                                Column(modifier = Modifier) {
                                    Text(
                                        text = item.TenSP,
                                        modifier = Modifier
                                            .width(170.dp)
                                            .height(19.dp),
//                                       .background(color = Color.Blue),
                                        fontSize = 14.sp,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight(600),
                                        color = Color.Gray
                                    )
                                    Text(
                                        text = "$ ${item.Price.toString()}.00",
                                        fontSize = 16.sp, modifier = Modifier
                                            .width(170.dp)
                                            .height(19.dp)
//                                       .background(color = Color.Blue)

                                        ,

                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight(700),
                                        color = Color.Black
                                    )
                                    Spacer(
                                        modifier = Modifier
                                            .height(23.dp)
                                    )
                                    Row(
                                        modifier = Modifier
                                            .padding(start = 0.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(30.dp)
                                                .clip(
                                                    shape = RoundedCornerShape(
                                                        topStart = 5.dp,
                                                        topEnd = 5.dp,
                                                        bottomEnd = 5.dp,
                                                        bottomStart = 5.dp
                                                    )
                                                )
                                                .background(color = Color(0xFFE0E0E0)),
                                            contentAlignment = Alignment.Center, // Canh giữa cả theo chiều ngang và chiều dọc,

                                        ) {
                                            Text(
                                                text = "+",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                fontStyle = FontStyle.Normal
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        //////////////////////////////////////////////////////////////
                                        Box(
                                            modifier = Modifier
                                                .size(30.dp)
                                                .clip(
                                                    shape = RoundedCornerShape(
                                                        topStart = 5.dp,
                                                        topEnd = 5.dp,
                                                        bottomEnd = 5.dp,
                                                        bottomStart = 5.dp
                                                    )
                                                )
                                                //background: #F0F0F0;
                                                .background(color = Color.White),
                                            contentAlignment = Alignment.Center, // Canh giữa cả theo chiều ngang và chiều dọc,

                                        ) {
                                            Text(
                                                text = "01",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                fontStyle = FontStyle.Normal
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        ///////////////////////////////////////////////////////////
                                        Box(
                                            modifier = Modifier
                                                .size(30.dp)
                                                .clip(
                                                    shape = RoundedCornerShape(
                                                        topStart = 5.dp,
                                                        topEnd = 5.dp,
                                                        bottomEnd = 5.dp,
                                                        bottomStart = 5.dp
                                                    )
                                                )
                                                .background(color = Color(0xFFE0E0E0)),
                                            contentAlignment = Alignment.Center, // Canh giữa cả theo chiều ngang và chiều dọc,

                                        ) {
                                            Text(
                                                text = "-",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold,
                                                fontStyle = FontStyle.Normal
                                            )
                                        }
                                    }//
                                }
                                Spacer(
                                    modifier = Modifier
                                        .width(8.dp)
                                )
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .border(
                                            BorderStroke(
                                                1.dp,
                                                Color.Black
                                            ), // Viền màu đen với độ dày 1 dp
                                            shape = CircleShape
                                        )
                                        .background(
                                            //background: #F0F0F0;
                                            color = Color(0xFFFAF4F4), // Màu nền của vòng tròn ngoài
                                            shape = CircleShape // Hình dạng tròn
                                        )
                                ) {
                                    Text(
                                        text = "x",
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                        }//card

                    }
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 35.dp)
                            .width(335.dp)
                            .height(2.dp)
                            .background(color = Color(0xFFF0F0F0)) // Màu nền của đường thẳng
                    )

                }

            }//lazy column

        }
    }//box
    Column(
        modifier = Modifier
            .padding(top = 650.dp, start = 22.dp, end = 20.dp)
            //    .fillMaxSize()
            // .background(color = Color.Blue)
            .padding(10.dp), // Thêm padding nếu cần thiết
        verticalArrangement = Arrangement.SpaceBetween // Phân bố đều khoảng cách giữa các phần tử

    ){
  //      Spacer(modifier = Modifier.weight(0.1f)) // Thêm khoảng trống để đẩy chữ xuống cuối màn hình
      Card(modifier = Modifier
          .width(335.dp)
          .height(44.dp),
          elevation =  CardDefaults.cardElevation(
              defaultElevation = 10.dp
          ),
          colors = CardDefaults.cardColors(
              containerColor = Color.White
          )
      ) {
          Row {
              Text(text = "Enter your promo code",
                  modifier = Modifier
                      .padding(start = 20.dp, top = 11.dp, bottom = 11.dp, end = 108.dp)
                      .width(163.dp)
                      .height(22.dp))
Box (modifier = Modifier
    .clip(shape = RoundedCornerShape(7.dp))
    .background(color = Color.Black)
    .size(44.dp),
    contentAlignment = Alignment.Center
){
    Icon(
        imageVector = Icons.Default.ArrowForwardIos,
        contentDescription = "Back Icon",
        tint = Color.White

    )
} }


      }
        Row(modifier = Modifier
            .padding(horizontal = 16.dp)
            .background(color = Color(0xFFF8F5F5))
            .width(335.dp),
            verticalAlignment = Alignment.CenterVertically,
           ) {
            Text(text = "Total:",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .width(51.dp)
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
        Card(modifier = Modifier
            .width(335.dp)
            .height(59.dp),
            elevation =  CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF242424),

            )) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .clickable{  // Tạo một Intent để điều hướng
                        val intent = Intent(context, ManHinhCuoiActivity::class.java).apply {
                        }
                        context.startActivity(intent)},
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Check out", color = Color.White)
            }
        }
    }

}
@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartScreenPreview() {
    Lab2Theme {
        CartScreen();
    }
}