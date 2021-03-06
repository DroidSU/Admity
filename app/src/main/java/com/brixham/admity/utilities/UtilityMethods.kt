package com.brixham.admity.utilities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.brixham.admity.R


class UtilityMethods {

    fun showProgressDialog(context: Context) : AlertDialog{
        val builder = AlertDialog.Builder(context, R.style.transparentDialog)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
        builder.setView(dialogView)

        val alertDialog : AlertDialog = builder.create();
        alertDialog.setCancelable(false)
        return alertDialog
    }

    fun showFailedDialog(context: Context, message : String) : AlertDialog{
        val builder = AlertDialog.Builder(context, R.style.CustomAlertDialog)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_failed, null)
        val textView: TextView = dialogView.findViewById(R.id.tv_failed_dialog_body)
        textView.text = message

        builder.setView(dialogView)

        return builder.create()
    }
}