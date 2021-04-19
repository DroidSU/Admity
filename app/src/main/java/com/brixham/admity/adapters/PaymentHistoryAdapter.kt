package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class PaymentHistoryAdapter: RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>() {

    private val textV1 = arrayOf("Rita Debnath","Bethany Cline","Bethany Cline","Rita Debnath","Rita Debnath")
    private val textV2 = arrayOf("Class(10)","Class(9)","Class(8)","Class(7)","Class(6)")
    private val textV3 = arrayOf("Annual Fee","Half year Fee","Annual Fee","Annual Fee","Annual Fee")
    private val textV4 = arrayOf("23 March 2021","23 April 2021","23 May 2021","23 June 2021","23 July 2021")
    private val textV5 = arrayOf("2999/-","3999/-","1999/-","2999/-","2999/-")
    private val textV6 = arrayOf("Admin","Admin","Admin","Admin","Admin")



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        var textViewStdName: TextView = view.findViewById(R.id.payment_history_student_name)
        var textViewStdClass: TextView = view.findViewById(R.id.payment_history_student_class)
        var textViewFeeType: TextView = view.findViewById(R.id.payment_history_fee_type)
        var textViewFeeDate: TextView = view.findViewById(R.id.payment_history_fee_date)
        var textViewFeeAmount: TextView = view.findViewById(R.id.payment_history_fee_amount)
        var textViewFeeBy: TextView = view.findViewById(R.id.payment_history_payment_by)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentHistoryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.payment_history_layout, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: PaymentHistoryAdapter.ViewHolder, position: Int) {
        holder.textViewStdName.text = textV1[position]
        holder.textViewStdClass.text = textV2[position]
        holder.textViewFeeType.text = textV3[position]
        holder.textViewFeeDate.text = textV4[position]
        holder.textViewFeeAmount.text = textV5[position]
        holder.textViewFeeBy.text = textV6[position]
    }
    override fun getItemCount(): Int {
        return textV1.size    }



}