package com.brixham.admity.network

import com.brixham.admity.models.*
import com.brixham.admity.network.interceptors.ConnectivityInterceptor
import com.brixham.admity.network.interceptors.ResponseInterceptor
import com.brixham.admity.utilities.Constants.Companion.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiService {
    @POST("Login/Login")
    fun loginUser(@Body body: HashMap<String, String>): Deferred<LoginResponseModel>

    @POST("Credentials/Passwordchange")
    fun changePwdUser(@HeaderMap headers: Map<String, String>, @Body body: HashMap<String, String>): Deferred<ChangePasswordResponseModel>

    @POST("Profile/ProfileDataFetch")
    fun getStudentProfile(@HeaderMap headers: Map<String, String>): Deferred<StudentProfileResponseModel>

    @POST("Myinstitute/Instituteholiday")
    fun getHoliday(@HeaderMap headers: Map<String, String>): Deferred<HolidayResponseModel>

    @POST("Notification/StudentNotification")
    fun getNotifications(@HeaderMap headers: Map<String, String>) : Deferred<NotificationsResponseModel>

    @POST("Myinstitute/InstitutePros")
    fun getProspectus(@HeaderMap headers: Map<String, String>) : Deferred<MyProspectusModel>

    @POST("Myinstitute/Notice")
    fun getNotice(@HeaderMap headers: Map<String, String>) : Deferred<NoticeResponseModel>

    @POST("Profile/FAQs")
    fun getFaq(@HeaderMap headers: Map<String, String>) : Deferred<FAQResponseModel>


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
                    .header("X-ApiKey", "8f92cb92-c007-448b-b488-brixham-1650492dfd00")
                    .build()

                return@Interceptor chain.proceed(request)

            }
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(BasicAuthInterceptor(username = "School_Project", password = "School@2021"))
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

class BasicAuthInterceptor(username: String, password: String): Interceptor {
    private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()
        return chain.proceed(request)
    }
}