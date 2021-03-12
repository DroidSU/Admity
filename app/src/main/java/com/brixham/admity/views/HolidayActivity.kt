package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adaptars.HolidayAdapter
import com.brixham.admity.adaptars.MsgRecyclerAdapter

class HolidayActivity : AppCompatActivity() {

    private lateinit var backImgMsg: ImageView
    private lateinit var imgHolidayBellIcon: ImageView
    private lateinit var textViewHoliday: TextView

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<HolidayAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday)
        backImgMsg = findViewById(R.id.imgIcLeftArrow)
        imgHolidayBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHoliday = findViewById(R.id.textHeaderHoliday)
        recycler_adaptar = findViewById(R.id.recycler_holiday)
        backImgMsg.visibility = View.VISIBLE
        imgHolidayBellIcon.visibility = View.VISIBLE
        textViewHoliday.visibility = View.VISIBLE



        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = HolidayAdapter()
        recycler_adaptar.adapter = adapter


    }
}