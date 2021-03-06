package com.brixham.admity.utilities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.brixham.admity.R


class UtilityMethods {

    fun showProgressDialog(context: Context) : AlertDialog{
        val builder = AlertDialog.Builder(context)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
        builder.setView(dialogView)

        val alertDialog : AlertDialog = builder.create();
        alertDialog.setCancelable(false)
        return alertDialog
    }

    fun showFailedDialog(context: Context, message : String) : AlertDialog{
        val builder = AlertDialog.Builder(context)
        val dialogView: View = LayoutInflater.from(context).inflate(R.layout.dialog_failed, null)
        builder.setView(dialogView)

        return builder.create()
    }
}