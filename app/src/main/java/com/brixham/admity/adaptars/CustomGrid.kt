package com.brixham.admity.adaptars

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class CustomGrid(
    c: Context,
    web: Array<String>,
    Imageid: IntArray
) :
    BaseAdapter() {
    private val mContext: Context
    private val web: Array<String>
    private val Imageid: IntArray
    lateinit var textView: TextView
    lateinit var imageView: ImageView
    lateinit var view:  View

    override fun getCount(): Int {
        // TODO Auto-generated method stub
        return web.size
    }

    override fun getItem(position: Int): Any? {
        // TODO Auto-generated method stub
        return null
    }

    override fun getItemId(position: Int): Long {
        // TODO Auto-generated method stub
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        // TODO Auto-generated method stub

        val inflater: LayoutInflater = mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            view = View(mContext)
           // view = inflater.inflate(R.layout.)


            /*grid = inflater.inflate(R.layout.grid_single, parent,null)
            val textView: TextView = grid.findViewById(R.id.grid_text) as TextView
            val imageView: ImageView = grid.findViewById(R.id.grid_image) as ImageView
            textView.setText(web[position])
            imageView.setImageResource(Imageid[position])*/
        } else {
            view = convertView
        }
        return view
    }

    init {
        mContext = c
        this.Imageid = Imageid
        this.web = web
    }
}

