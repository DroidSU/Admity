package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R

class TransportAdapter: RecyclerView.Adapter<TransportAdapter.ViewHolder>() {

    private val images1 = intArrayOf(
        R.drawable.transport_img,
        R.drawable.transport_img,
        R.drawable.transport_img,
        R.drawable.transport_img,
        R.drawable.transport_img,)
    private val textV1 = arrayOf("Location Name 1","Location Name 2","Location Name 3","Location Name 4","Location Name 5")
    private val images2 = intArrayOf(
        R.drawable.money_icon,
        R.drawable.money_icon,
        R.drawable.money_icon,
        R.drawable.money_icon,
        R.drawable.money_icon,)
    private val textV2 = arrayOf("Monthly Fee","Monthly Fee","Monthly Fee","Monthly Fee","Monthly Fee")
    private val textV3 = arrayOf("Rs. 1000","Rs. 1000","Rs. 1000","Rs. 1000","Rs. 1000")


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var displayTransportImageView : ImageView = view.findViewById(R.id.trasport_cicleImg)
        var textViewTransportName: TextView = view.findViewById(R.id.transportLocation_name)
        var displayTransportMoneyImageView : ImageView = view.findViewById(R.id.transport_moneyCircleImg)
        var textViewMonthlyFee: TextView = view.findViewById(R.id.textView_transMonthlyMoney)
        var textViewMonthlyAmount: TextView = view.findViewById(R.id.textView_TransMonthlyMoneyAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.transport_list, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: TransportAdapter.ViewHolder, position: Int) {
        holder.displayTransportImageView.setImageResource(images1[position])
        holder.textViewTransportName.text = textV1[position]
        holder.displayTransportMoneyImageView.setImageResource(images2[position])
        holder.textViewMonthlyFee.text = textV2[position]
        holder.textViewMonthlyAmount.text = textV3[position]
    }
    override fun getItemCount(): Int {
        return images1.size -1
    }



}