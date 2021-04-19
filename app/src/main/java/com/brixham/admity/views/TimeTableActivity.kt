package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.R.string.*
import com.brixham.admity.adapters.RoutineAdaper
import com.brixham.admity.adapters.TimeTableAdapter
import com.brixham.admity.models.Status
import com.brixham.admity.utilities.Constants
import java.text.SimpleDateFormat
import java.util.*


class TimeTableActivity : AppCompatActivity() {

    private lateinit var textViewToolbarHeader : TextView
    private lateinit var imageViewBackIcon : ImageView
    private lateinit var imageViewMenuIcon : ImageView
    private lateinit var imgEnquiryBellIcon: ImageView

    private lateinit var textViewDate: TextView
    private lateinit var calendar: Calendar
    private lateinit var simpleDateFormat: SimpleDateFormat

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<TimeTableAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    private lateinit var textViewMonday : TextView
    private lateinit var textViewTuesday : TextView
    private lateinit var textViewWednesday : TextView
    private lateinit var textViewThursday : TextView
    private lateinit var textViewFriday : TextView
    private lateinit var textViewSaturday : TextView

    var Date: String? = null

    private var selectedDay : String = Constants.MONDAY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)
        setupView()

        textViewMonday.setOnClickListener {
            selectedDay = Constants.MONDAY
            textViewMonday.setBackgroundColor(resources.getColor(R.color.green))
            Log.d("TAG", "Monday tapped")
            textViewTuesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewWednesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewThursday.setBackgroundColor(resources.getColor(R.color.white))
            textViewFriday.setBackgroundColor(resources.getColor(R.color.white))
            textViewSaturday.setBackgroundColor(resources.getColor(R.color.white))

        }
        textViewTuesday.setOnClickListener {
            selectedDay = Constants.TUESDAY
            Log.d("TAG", "Tuesday tapped")
            textViewTuesday.setBackgroundColor(resources.getColor(R.color.green))
            textViewMonday.setBackgroundColor(resources.getColor(R.color.white))
            textViewWednesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewThursday.setBackgroundColor(resources.getColor(R.color.white))
            textViewFriday.setBackgroundColor(resources.getColor(R.color.white))
            textViewSaturday.setBackgroundColor(resources.getColor(R.color.white))
        }
        textViewWednesday.setOnClickListener {
            selectedDay = Constants.WEDNESDAY
            Log.d("TAG", "Wednesday tapped")
            textViewWednesday.setBackgroundColor(resources.getColor(R.color.green))
            textViewMonday.setBackgroundColor(resources.getColor(R.color.white))
            textViewTuesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewThursday.setBackgroundColor(resources.getColor(R.color.white))
            textViewFriday.setBackgroundColor(resources.getColor(R.color.white))
            textViewSaturday.setBackgroundColor(resources.getColor(R.color.white))
        }
        textViewThursday.setOnClickListener {
            selectedDay = Constants.THURSDAY
            Log.d("TAG", "Thursday tapped")
            textViewThursday.setBackgroundColor(resources.getColor(R.color.green))
            textViewMonday.setBackgroundColor(resources.getColor(R.color.white))
            textViewTuesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewWednesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewFriday.setBackgroundColor(resources.getColor(R.color.white))
            textViewSaturday.setBackgroundColor(resources.getColor(R.color.white))
        }
        textViewFriday.setOnClickListener {
            selectedDay = Constants.FRIDAY
            Log.d("TAG", "Friday tapped")
            textViewFriday.setBackgroundColor(resources.getColor(R.color.green))
            textViewMonday.setBackgroundColor(resources.getColor(R.color.white))
            textViewTuesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewWednesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewThursday.setBackgroundColor(resources.getColor(R.color.white))
            textViewSaturday.setBackgroundColor(resources.getColor(R.color.white))
        }
        textViewSaturday.setOnClickListener {
            selectedDay = Constants.SATURDAY
            Log.d("TAG", "Saturday tapped")
            textViewSaturday.setBackgroundColor(resources.getColor(R.color.green))
            textViewMonday.setBackgroundColor(resources.getColor(R.color.white))
            textViewTuesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewWednesday.setBackgroundColor(resources.getColor(R.color.white))
            textViewThursday.setBackgroundColor(resources.getColor(R.color.white))
            textViewFriday.setBackgroundColor(resources.getColor(R.color.white))
        }
    }

    private fun setupView() {
        imageViewBackIcon = findViewById(R.id.imgIcLeftArrow)
        imgEnquiryBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewToolbarHeader = findViewById(R.id.toolbar_header)
        recycler_adaptar = findViewById(R.id.timetable_recyclerView)
        textViewMonday = findViewById(R.id.textView_monday)
        textViewTuesday = findViewById(R.id.textView_tuesday)
        textViewWednesday = findViewById(R.id.textView_wednesday)
        textViewThursday = findViewById(R.id.textView_thursday)
        textViewFriday = findViewById(R.id.textView_friday)
        textViewSaturday = findViewById(R.id.textView_saturday)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager

        adapter = TimeTableAdapter()
        recycler_adaptar.adapter = adapter

        textViewToolbarHeader.text = getString(institute_timetable)
        imageViewBackIcon.visibility = View.VISIBLE
        textViewToolbarHeader.visibility = View.VISIBLE

        imageViewBackIcon.setOnClickListener {
            onBackPressed()
        }
        textViewDate = findViewById(R.id.textViewDateMonthYear)
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd MMMM,yyyy")
        Date = simpleDateFormat.format(calendar.time)
        textViewDate.text = Date
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}