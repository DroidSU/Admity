package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.GuardianCallData
import com.brixham.admity.models.GuardianMeetingData
import java.util.ArrayList

class GuardianMeetingAdapter(private var guardianMeetingList: ArrayList<GuardianMeetingData>) : RecyclerView.Adapter<GuardianMeetingAdapter.ViewHolder>() {

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
    private val status = arrayOf("Refuse","Active","Refuse","Active","Refuse","Refuse","Active")
    private val headline = arrayOf("Testing","Testing","Testing","Testing","Testing","Testing","Testing")
    private val purpuse = arrayOf("Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known","Lorem ipsum, or lipsum as it is sometimes known")*/
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var guardianImg : ImageView = view.findViewById(R.id.guardian_meeting_img)
        var textViewdate : TextView = view.findViewById(R.id.guardianMeeting_date)
        var textViewtime : TextView = view.findViewById(R.id.guardianMeeting_time)
        var textViewplace : TextView = view.findViewById(R.id.guardianMeeting_place)
        var textViewstatus : TextView = view.findViewById(R.id.guardianMeeting_status)
        var textViewheadline : TextView = view.findViewById(R.id.guardianMeeting_headlines)
        var textViewpurpose : TextView = view.findViewById(R.id.guardianMeeting_purpose)
        var textViewSpeaker : TextView = view.findViewById(R.id.guardianMeeting_speakers)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuardianMeetingAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.guardian_meeting_list, parent, false)
        return ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*holder.guardianImg.setImageResource(images[position])
        holder.textViewdate.text = date[position]
        holder.textViewtime.text = times[position]
        holder.textViewplace.text = place[position]
        holder.textViewstatus.text = status[position]
        holder.textViewheadline.text = headline[position]
        holder.textViewpurpose.text = purpuse[position]*/

        holder.textViewdate.text = guardianMeetingList[position].meeting_Date
        holder.textViewtime.text = guardianMeetingList[position].meeting_Time
        holder.textViewplace.text = guardianMeetingList[position].meeting_Place
        holder.textViewSpeaker.text = guardianMeetingList[position].speckers
        holder.textViewstatus.text = guardianMeetingList[position].meetingstatus
        holder.textViewheadline.text = guardianMeetingList[position].head_Line
        holder.textViewpurpose.text = guardianMeetingList[position].purpose
    }
    override fun getItemCount(): Int {
        return guardianMeetingList.size
    }
}