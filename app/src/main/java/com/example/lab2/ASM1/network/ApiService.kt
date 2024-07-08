package com.example.lab2.ASM1.network

import com.example.lab2.ASM1.model.Category
import com.example.lab2.ASM1.model.LoginRequest
import com.example.lab2.ASM1.model.LoginResponse
import com.example.lab2.ASM1.model.Product
import com.example.lab2.ASM1.model.RegisterRequest
import com.example.lab2.ASM1.model.RegisterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.POST
interface ApiService {
    @GET("/all")
    suspend fun getCategories(): List<Category>
    @GET("/category/{categoryID}")
    suspend fun getProductsForCategory(@Path("categoryID") categoryID: Int): List<Product>
    @POST("/register")
    suspend fun registerUser(@Body request: RegisterRequest): RegisterResponse
    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginResponse
    @GET("/product/{productID}")
    suspend fun getProduct(@Path("productID") productID: Int): List<Product>

}

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:3000"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
