package com.brixham.admity.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.RoutineAdaper
import com.brixham.admity.utilities.Constants
import com.google.android.material.tabs.TabLayout

class RoutineActivity : AppCompatActivity() {

    private lateinit var routineTabLayout: TabLayout
    private lateinit var backImgRoutine: ImageView
    private lateinit var imgRoutineBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var textViewMonday : TextView
    private lateinit var textViewTuesday : TextView
    private lateinit var textViewWednesday : TextView
    private lateinit var textViewThursday : TextView
    private lateinit var textViewFriday : TextView
    private lateinit var textViewSaturday : TextView

    private lateinit var imageViewRightArrow: ImageView
    private lateinit var imageViewLeftArrow: ImageView
    private lateinit var textViewClass : TextView

    private var selectedDay : String = Constants.MONDAY
    private var which = 0
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RoutineAdaper.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)
        setupView()
        imgRoutineBellIcon.setOnClickListener {
            var intent: Intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
            finish()
        }
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
        backImgRoutine = findViewById(R.id.imgIcLeftArrow)
        imgRoutineBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)
        textViewHeader.text = getString(R.string.routine)
        backImgRoutine.visibility = View.VISIBLE
        imgRoutineBellIcon.visibility = View.GONE
        textViewHeader.visibility = View.VISIBLE

        backImgRoutine.setOnClickListener {
            onBackPressed()
        }
        recycler_adaptar = findViewById(R.id.routine_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = RoutineAdaper()
        recycler_adaptar.adapter = adapter

        textViewMonday = findViewById(R.id.mon_routine)
        textViewTuesday = findViewById(R.id.tue_routine)
        textViewWednesday = findViewById(R.id.wed_routine)
        textViewThursday = findViewById(R.id.thu_routine)
        textViewFriday = findViewById(R.id.fri_routine)
        textViewSaturday = findViewById(R.id.sat_routine)

        textViewClass = findViewById(R.id.routine_class)
        imageViewRightArrow = findViewById(R.id.routine_img_right_arrow)
        imageViewRightArrow.setOnClickListener {
            when (which) {
                0 -> {
                    textViewClass.setText("10-B")
                    which++
                }
                1 -> {
                    textViewClass.setText("11-A")
                    which++
                }
                2 -> {
                    textViewClass.setText("11-B")
                    which = 0
                }
            }

        }
        imageViewLeftArrow = findViewById(R.id.routine_img_left_arrow)
        imageViewLeftArrow.setOnClickListener {
            when (which) {
                0 -> {
                    textViewClass.setText("10-B")
                    which++
                }
                1 -> {
                    textViewClass.setText("11-A")
                    which++
                }
                2 -> {
                    textViewClass.setText("11-B")
                    which = 0
                }
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}