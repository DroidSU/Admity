package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.FAQResponseData
import com.brixham.admity.models.GuardianCallData
import java.util.ArrayList

class GuardianCallAdapter(private var guardianCallList: ArrayList<GuardianCallData>) : RecyclerView.Adapter<GuardianCallAdapter.ViewHolder>() {

    private lateinit var view : View
    /*private val images = intArrayOf(
        R.drawable.ic_guardiancall,
        R.drawable.ic_guardiancall,
        R.drawable.ic_guardiancall,
        R.drawable.ic_guardiancall,
        R.drawable.ic_guardiancall,
        R.drawable.ic_guardiancall,
        R.drawable.ic_guardiancall)
    private val date = arrayOf("11-04-2020, ","11-04-2020, ","11-04-2020, ","11-04-2020, ","11-04-2020, ","11-04-2020, ","11-04-2020, ")
    private val times = arrayOf("1:45 pm","1:45 pm","1:45 pm","1:45 pm","1:45 pm","1:45 pm","1:45 pm")
    private val place = arrayOf("School","School","School","School","School","School","School")
    private val status = arrayOf("Active","Active","Refuse","Active","Refuse","Refuse","Active")
    private val headline = arrayOf("Testing","Testing","Testing","Testing","Testing","Testing","Testing")
    private val purpuse = arrayOf("Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known")*/
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var guardianImg : ImageView = view.findViewById(R.id.guardian_img)
        var textViewdate : TextView = view.findViewById(R.id.guardianCall_date)
        var textViewtime : TextView = view.findViewById(R.id.guardianCall_time)
        var textViewplace : TextView = view.findViewById(R.id.guardianCall_place)
        var textViewstatus : TextView = view.findViewById(R.id.guardianCall_status)
        var textViewheadline : TextView = view.findViewById(R.id.guardianCall_headlines)
        var textViewpurpose : TextView = view.findViewById(R.id.guardianCall_purpose)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuardianCallAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.guardian_call_list, parent, false)
        return ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.textViewdate.text = guardianCallList[position].datetime
       holder.textViewtime.text = guardianCallList[position].time
       holder.textViewplace.text = guardianCallList[position].place
       holder.textViewheadline.text = guardianCallList[position].headLine
       holder.textViewpurpose.text = guardianCallList[position].purpose
        /*holder.guardianImg.setImageResource(images[position])
        holder.textViewdate.text = date[position]
        holder.textViewtime.text = times[position]
        holder.textViewplace.text = place[position]
        holder.textViewstatus.text = status[position]
        holder.textViewheadline.text = headline[position]
        holder.textViewpurpose.text = purpuse[position]*/
    }
    override fun getItemCount(): Int {
        return guardianCallList.size
    }
}