package com.brixham.admity.network

import com.brixham.admity.models.LoginResponseModel
import com.brixham.admity.network.interceptors.ConnectivityInterceptor
import com.brixham.admity.network.interceptors.ResponseInterceptor
import com.brixham.admity.utilities.Constants.Companion.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("Login/Login")
    @FormUrlEncoded
    fun loginUser(@Field("Userid") userId  : String, @Field("Password") password : String, @Field("Fcmtoken") fcmToken : String): Deferred<LoginResponseModel>


    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor,
            responseInterceptor: ResponseInterceptor
        ): ApiService {

            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)

            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(responseInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}