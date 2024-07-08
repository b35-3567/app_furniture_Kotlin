package com.example.lab2.ASM1.screen

import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.R
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ASM1.viewmodel.CategoryViewModel
import com.example.lab2.ASM1.model.Product
import com.example.lab2.ASM1.network.RetrofitClient

@Composable
fun HomeScreen() {
    val viewModel: CategoryViewModel = viewModel()
    var selectedCategory by remember { mutableStateOf("Popular") }
    var selectedCategoryId by remember { mutableStateOf(0) }
    val context = LocalContext.current

    // Fetch products when selectedCategoryId changes
    LaunchedEffect(selectedCategoryId) {
        if (selectedCategoryId != 0) {
            try {
                val products = RetrofitClient.apiService.getProductsForCategory(selectedCategoryId)
                for (product in products) {
                    Log.d("Product", "ProductID: ${product.ProductID}, ProductName: ${product.ProductName}, Price: ${product.Price}, Quantity: ${product.Quantity}, CategoryID: ${product.CategoryId}, ProductImage: ${product.ProductImage}")
                }
            } catch (e: Exception) {
                Log.e("Product", "Error fetching products: ${e.message}")
            }
        }
    }

    Column {
        Row {
            Spacer(modifier = Modifier.weight(0.3f))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
            Spacer(modifier = Modifier.weight(1.5f))
            Column {
                Text(
                    text = "Make home",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black
                )
                Text(
                    text = "BEAUTIFUL",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.weight(1.5f))
            Icon(
                imageVector = Icons.Default.AddShoppingCart,
                contentDescription = "Cart Icon" ,
                modifier = Modifier
                    .clickable {
                        val intent = Intent(context,CartScreenActivity::class.java)
                        context.startActivity(intent)
                    }

            )
            Spacer(modifier = Modifier.weight(0.3f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.categories.isEmpty()) {
            Text(text = "Loading categories...")
        } else {
            LazyRow(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(viewModel.categories.size) { index ->
                    val category = viewModel.categories[index]
                    val imageResId = when (category.CategoryName) {
                        "Popular" -> R.drawable.img_5
                        "Chair" -> R.drawable.img_4
                        "Table" -> R.drawable.img_6
                        "Armchair" -> R.drawable.img_7
                        "Bed" -> R.drawable.img_8
                        else -> R.drawable.img_5
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .clickable {
                                selectedCategory = category.CategoryName
                                selectedCategoryId = category.CategoryID
                            }
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    if (category.CategoryName == selectedCategory) Color(0xFF303030)
                                    else Color(0xFFE0E0E0)
                                )
                        ) {
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = category.CategoryName,
                                modifier = Modifier
                                    .size(28.dp),
                                colorFilter = ColorFilter.tint(if (category.CategoryName == selectedCategory) Color.White else Color(0xFF909090))
                            )
                        }
                        Text(
                            text = category.CategoryName,
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LaunchedEffect(selectedCategoryId) {
            if (selectedCategoryId != 0) {
                viewModel.fetchProductsForCategory(selectedCategoryId)
            }
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 8.dp,
            contentPadding = PaddingValues(8.dp)
        ) {
            items(viewModel.products) { item ->
                FunitreItem(item) { productId ->

                    // Điều hướng đến màn hình chi tiết sản phẩm, truyền ProductId
                    // Tạo một Intent để điều hướng
                    val intent = Intent(context, ProductSeenActivity::class.java).apply {
                        putExtra("PRODUCT_ID", productId)
                    }
                    context.startActivity(intent)
                }

            }
        }
    }
}

@Composable
fun FunitreItem(item: Product, onItemClick: (Int) -> Unit) {
//fun FunitreItem(item: Product) {
    val context = LocalContext.current
    val imageResId = if (!item.ProductImage.isNullOrEmpty()) {
        context.resources.getIdentifier(item.ProductImage, "drawable", context.packageName)
    } else {
        R.drawable.img // Sử dụng hình ảnh mặc định nếu productImage null hoặc rỗng
    }
    Log.d("Product", item.toString())
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(item.ProductID)
                     Log.d("item.productID","${item.ProductID.toString()}")}, // Thêm sự kiện nhấp vào Card
        backgroundColor = Color.White,
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = item.ProductName ?: "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(200.dp),
                )
                Image(
                    painter = painterResource(id = R.drawable.img_13),
                    contentDescription = "item.name",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(top = 160.dp, start = 130.dp)
                        .width(30.dp)
                        .height(30.dp),
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = item.ProductName ?: "Unknown", // Sử dụng "Unknown" nếu productName là null
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = "$${item.Price ?: 0.0}", // Sử dụng 0.0 nếu price là null
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.R)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    Lab2Theme {
        HomeScreen()
    }
}
