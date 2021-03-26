package com.brixham.admity.utilities

//import sun.misc.IOUtils
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.brixham.admity.R
import com.brixham.admity.network.ApiService
import com.brixham.admity.utilities.ServiceGenerator.createService
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UtilityMethods {

    fun showProgressDialog(context: Context) : AlertDialog{
        val builder = AlertDialog.Builder(context, R.style.transparentDialog)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
        builder.setView(dialogView)

        val alertDialog : AlertDialog = builder.create();
        alertDialog.setCancelable(false)
        return alertDialog
    }

    fun showFailedDialog(context: Context, message: String) : AlertDialog{
        val builder = AlertDialog.Builder(context, R.style.CustomAlertDialog)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_failed, null)
        val textView: TextView = dialogView.findViewById(R.id.tv_failed_dialog_body)
        textView.text = message

        builder.setView(dialogView)

        return builder.create()
    }
    /*fun download() {
        *//*val api: ApiService = ApiService.retrofit.create(ApiService::class.java)
        api.download("http://192.168.43.135/retro/pic.jpg")
            .enqueue(object : NetworkCallback<DownloadResponseModel?>() {
                fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                    try {
                        val path: File = Environment.getExternalStorageDirectory()
                        val file = File(path, "file_name.jpg")
                        val fileOutputStream = FileOutputStream(file)
                        IOUtils.write(response.body().bytes(), fileOutputStream)
                    } catch (ex: Exception) {
                    }
                }

                fun onFailure(call: Call<ResponseBody?>?, t: Throwable?) {}
            })*//*

    }*/
    object ServiceGenerator {
        const val API_BASE_URL = "http://your.api-base.url/"
        private val httpClient = OkHttpClient.Builder()
        private val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        fun <S> createService(serviceClass: Class<S>?): S {
            val retrofit = builder.client(httpClient.build()).build()
            return retrofit.create(serviceClass)
        }
    }
    private fun downloadFile() {
    }
}