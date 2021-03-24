package com.brixham.admity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.models.MyPropectusData
import java.util.*

class RecycleProspectAdapter(private var prospectusList: ArrayList<MyPropectusData>) :
    RecyclerView.Adapter<RecycleProspectAdapter.ProspectusViewHolder>() {

    private lateinit var view : View

    class ProspectusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var prospectusId : TextView = itemView.findViewById(R.id.expand_txtId)
        var prospectusName : TextView = itemView.findViewById(R.id.expand_txtName)
        var propectusDetils: TextView = itemView.findViewById(R.id.expand_txtProspectus)
        //var textViewTime: TextView = itemView.findViewById(R.id.textViewNotifyTime)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProspectusViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.prospectus_list, parent, false)
        return ProspectusViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProspectusViewHolder, position: Int) {
        holder.prospectusId.text = prospectusList[position].pk_collegeProspectusId.toString()
        holder.prospectusName.text = prospectusList[position].prospectusName
        holder.propectusDetils.text = prospectusList[position].prospectus
    }

    override fun getItemCount(): Int {
        return prospectusList.size
    }




}