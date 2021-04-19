package com.brixham.admity.adapters

import android.content.Context
import android.graphics.Paint
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class MyTransactionAdapter (private val context: Context): RecyclerView.Adapter<MyTransactionAdapter.ViewHolder>() {

    val admission =  context.resources.getStringArray(R.array.admission_fees)
    val amount =  context.resources.getStringArray(R.array.transaction_amount)
    val paymentMode =  context.resources.getStringArray(R.array.offline_counter)
    val transactionId =  context.resources.getStringArray(R.array.transaction_id)
    val status =  context.resources.getStringArray(R.array.paid)
    val date =  context.resources.getStringArray(R.array._1st_april_2_20pm)
    private val images = intArrayOf(
        R.drawable.ic_download_red,
        R.drawable.ic_download_red,
        R.drawable.ic_download_red,
        R.drawable.ic_download_red,
        R.drawable.ic_download_red,
        R.drawable.ic_download_red,
        R.drawable.ic_download_red,
        R.drawable.ic_download_red,)

   /* private val admission = arrayOf("Admission Fees","Admission Fees","Admission Fees","Admission Fees","Admission Fees","Admission Fees","Admission Fees")
    private val amount = arrayOf("2000","2000","2000","2000","2000","2000","2000")
    private val paymentMode = arrayOf("Offline Counter","Offline Counter","Offline Counter","Offline Counter","Offline Counter","Offline Counter","Offline Counter")
    private val transactionId = arrayOf("T29374930373675739038769","T29374930373675739038769","T29374930373675739038769","T29374930373675739038769","T29374930373675739038769","T29374930373675739038769","T29374930373675739038769")
    private val status = arrayOf("Paid","Pending","Pending","Paid","Pending","Pending","Paid")
    private val date = arrayOf("1st April, 2:20pm","1st April, 2:20pm","1st April, 2:20pm","1st April, 2:20pm","1st April, 2:20pm","1st April, 2:20pm","1st April, 2:20pm")
    */



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewAdmission : TextView = view.findViewById(R.id.transactionId_admission_fees)
        var textViewAmount : TextView = view.findViewById(R.id.transactionId_amount)
        var textViewPaymentMode : TextView = view.findViewById(R.id.transactionId_payment_mode)
        var textViewTransactionId : TextView = view.findViewById(R.id.transactionId_id)
        var textViewStatus : TextView = view.findViewById(R.id.transactionId_status)
        var textViewDate : TextView = view.findViewById(R.id.transactionId_date)
        var transactionReceiptImg : ImageView = view.findViewById(R.id.transactionId_receipt_img)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTransactionAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.my_transaction_list_layout, parent, false)
        return ViewHolder(v)

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewAdmission.text = admission[position]
        holder.textViewAdmission.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.textViewAmount.text = amount[position]
        holder.textViewAmount.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.textViewPaymentMode.text = paymentMode[position]
        holder.textViewPaymentMode.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.textViewTransactionId.text = transactionId[position]
        holder.textViewTransactionId.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.textViewStatus.text = status[position]
        holder.textViewStatus.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.textViewDate.text = date[position]
        holder.textViewDate.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.transactionReceiptImg.setImageResource(images[position])

    }
    override fun getItemCount(): Int {
        return admission.size - 1
    }
}