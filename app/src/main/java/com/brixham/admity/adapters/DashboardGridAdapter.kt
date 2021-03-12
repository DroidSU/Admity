package com.brixham.admity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.brixham.admity.R
import com.brixham.admity.models.DashboardGridModel


class DashboardGridAdapter(context: Context?, private val resource: Int, private val itemList: List<DashboardGridModel>?) :
    ArrayAdapter<DashboardGridModel?>(context!!, resource, itemList!!) {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (itemView == null) {
            itemView = layoutInflater!!.inflate(R.layout.item_dashboard_grid, null)
        }

        imageView = itemView!!.findViewById(R.id.imageView_dashboard_item)
        textView = itemView.findViewById(R.id.textView_dashboard_item)

        imageView.setImageResource(itemList!![position].itemImageResource!!)
        textView.text = itemList[position].itemText

        return itemView
    }
}