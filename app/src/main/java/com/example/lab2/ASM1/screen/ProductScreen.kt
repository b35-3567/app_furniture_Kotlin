@file:OptIn(ExperimentalMaterial3Api::class)


package com.example.lab2.ASM1.screen

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.ASM1.viewmodel.ProductViewModel
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class ProductSeenActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productId = intent.getIntExtra("PRODUCT_ID", 0);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
         //  WindowCompat.setDecorFitsSystemWindows(window, false)
//        }
      //  enableFullscreenMode()
        // Thêm dòng này để kích hoạt vẽ tràn viền
  //      enableEdgeToEdge()
        // Thêm dòng này để kích hoạt vẽ tràn viền và thiết lập chế độ sáng/tối cho biểu tượng thanh trạng thái
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.White.toArgb()))
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                ProvideWindowInsets {
                    val systemUiController = rememberSystemUiController()
                    SideEffect {
                        systemUiController.setSystemBarsColor(
                            color = Color.Transparent,
                            darkIcons = false
                        )
                    }

            }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                  ProductScreen(productId);
                }
            }
        }
    }
    private fun enableFullscreenMode() {
        // Làm cho nội dung cửa sổ xuất hiện sau các thanh hệ thống
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        insetsController?.apply {
            hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}
@Composable

fun ProductScreen(productId:Int) {
    var quantity by remember { mutableStateOf(1) } // Lưu trữ số lượng hiện tại
    val productViewModel: ProductViewModel = viewModel()
    val product by productViewModel.product.collectAsState()

    LaunchedEffect(productId) {
        productViewModel.fetchProduct(productId)
    }
                Text(text = "Product ID: $productId",);
                product?.let { product ->
                    /*
            Column {
                Text(text = product.ProductName)
                Text(text = "Price: ${product.Price}")
                Text(text = "Quantity: ${product.Quantity}")
                // Thêm các phần khác để hiển thị thông tin sản phẩm chi tiết
            }
        } ?: run {
            Text(text = "Loading...")
        }

             */
                    Column {

                        Box {
                            val context = LocalContext.current
                            val imageId = remember(product.ProductImage) {
                                getImageResourceId(context, product.ProductImage)
                            }
                            Image(
                                painter = painterResource(id = imageId),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = 75.dp,)
                                    //.offset( y =(-90).dp) // Sử dụng offset để di chuyển phần tử
                                    .clip(
                                        shape = RoundedCornerShape(
                                            topStart = 0.dp,
                                            topEnd = 0.dp,
                                            bottomEnd = 0.dp,
                                            bottomStart = 80.dp
                                        )
                                    )
                                    .width(333.dp)
                                    .height(455.dp)
                                    .statusBarsPadding() // Đẩy nội dung lên trên để tránh thanh trạng thái

                            )
                            Image(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 23.dp, start = 23.dp)
                                    .size(120.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .padding(top = 149.dp, start = 48.dp)
                                    .width(64.dp)
                                    .height(192.dp)
                                    .clip(
                                        shape = RoundedCornerShape(
                                            topStart = 23.dp,
                                            topEnd = 23.dp,
                                            bottomEnd = 23.dp,
                                            bottomStart = 23.dp
                                        )
                                    )
                                    //background: #FFFFFF;
                                    .background(color = Color(0xFFFFFFFF))
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly, // Sử dụng Arrangement.SpaceEvenly
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .fillMaxSize()
                                ) {
                                    Box(
                                        contentAlignment = Alignment.Center, // Canh giữa các phần tử con bên trong Box
                                        modifier = Modifier
                                            .size(34.dp) // Kích thước của vòng tròn ngoài
                                            .background(
                                                color = Color(0xFF909090), // Màu nền của vòng tròn ngoài
                                                shape = CircleShape // Hình dạng tròn
                                            )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(24.dp) // Kích thước của vòng tròn trong
                                                .background(
                                                    color = Color(0xFFFFFFFF), // Màu nền của vòng tròn trong
                                                    shape = CircleShape // Hình dạng tròn
                                                )
                                        )
                                    }

                                    //

                                    Box(
                                        contentAlignment = Alignment.Center, // Canh giữa các phần tử con bên trong Box
                                        modifier = Modifier
                                            .size(34.dp) // Kích thước của vòng tròn ngoài
                                            .background(
                                                //background: #F0F0F0;
                                                color = Color(0xFFF0F0F0), // Màu nền của vòng tròn ngoài
                                                shape = CircleShape // Hình dạng tròn
                                            )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(24.dp) // Kích thước của vòng tròn trong
                                                .background(
                                                    //#B4916C
                                                    color = Color(0xFFB4916C), // Màu nền của vòng tròn trong
                                                    shape = CircleShape // Hình dạng tròn
                                                )
                                        )
                                    }
                                    //
                                    Box(
                                        contentAlignment = Alignment.Center, // Canh giữa các phần tử con bên trong Box
                                        modifier = Modifier
                                            .size(34.dp) // Kích thước của vòng tròn ngoài
                                            .background(
                                                //background: #F0F0F0;
                                                color = Color(0xFFF0F0F0), // Màu nền của vòng tròn ngoài
                                                shape = CircleShape // Hình dạng tròn
                                            )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(24.dp) // Kích thước của vòng tròn trong
                                                .background(
                                                    //background: #E4CBAD;
                                                    color = Color(0xFFE4CBAD), // Màu nền của vòng tròn trong
                                                    shape = CircleShape // Hình dạng tròn
                                                )
                                        )
                                    }
                                }
                            }
                        }
                        Text(
                            text = "${product.ProductName}",
                            modifier = Modifier
                                .padding(top = 23.dp, start = 25.dp)
                                .width(167.dp)
                                .height(30.dp),
                            fontWeight = FontWeight(500),
                            fontSize = 24.sp
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 25.dp)
                        ) {
                            Text(
                                text = "$ ${product.Price}",
                                modifier = Modifier
                                    .width(83.dp)
                                    .height(41.dp),
                                fontWeight = FontWeight(700),
                                fontSize = 30.sp
                            )
                            Spacer(modifier = Modifier.width(190.dp))
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
                                        .clickable{quantity++}
                                        .background(color = Color(0xFFE0E0E0)),
                                    contentAlignment = Alignment.Center, // Canh giữa cả theo chiều ngang và chiều dọc,

                                ) {
                                    Text(
                                        text = "+",
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Normal ,

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
                                        text = quantity.toString(),
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
                                        .clickable{if(quantity>1)quantity--}
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
                        Row(
                            modifier = Modifier
                                .padding(top = 12.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(start = 25.dp)
                                    .size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(14.dp))
                            Text(
                                text = "4.5",
                                modifier = Modifier
                                    .width(33.dp)
                                    .height(25.dp),
                                fontSize = 18.sp,
                                fontWeight = FontWeight(700),
                                fontStyle = FontStyle.Normal
                            )
                            Spacer(modifier = Modifier.width(25.dp))
                            Text(
                                text = "(50 reviews)",
                                modifier = Modifier
                                    .padding(top = 1.dp)
                                    .width(99.dp)
                                    .height(25.dp),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(600),
                                //background: #808080;
                                color = Color(0xFF808080),

                                )

                        }
                        Text(
                            text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. " +
                                    "This is truly one of the best furnitures in any family for now. With 3 different colors, " +
                                    "you can easily select the best match for your home. ",
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .width(425.dp)
                                .height(135.dp)
                                .padding(horizontal = 26.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(300),
                        )
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 35.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.bookmark),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(60.dp)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(20.dp)
                            )

                            Box(
                                modifier = Modifier
                                    .width(250.dp)
                                    .height(60.dp)
                                    .clip(
                                        shape = RoundedCornerShape(
                                            topStart = 15.dp,
                                            topEnd = 15.dp,
                                            bottomEnd = 15.dp,
                                            bottomStart = 15.dp
                                        )
                                    )
                                    .background(color = Color(0xFF242424))
                                    .clickable {
                                        // addToCart()
                                    },
                                contentAlignment = Alignment.Center // Center the content inside the Box
                            ) {
                                Text(
                                    text = "Add to cart",
                                    color = Color.White,
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        lineHeight = 60.sp
                                    )
                                )
                            }
                        }
                    }//cái chính
                } ?: run {
                    Text(text = "Loading...")
                }


                //contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)

}


fun getImageResourceId(context:Context,imageName: String):Int {
    return context.resources.getIdentifier(imageName,"drawable",context.packageName);
}

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductScreenPreview() {
    Lab2Theme {
        ProductScreen(productId = 1);
    }
}
