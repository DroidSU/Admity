package com.brixham.admity.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.HomeWorkAdapter
import com.brixham.admity.adapters.TimeTableAdapter
import com.brixham.admity.utilities.Constants
import java.text.SimpleDateFormat
import java.util.*


class HomeWorkFragment : Fragment() {

    private lateinit var currentView: View
    private lateinit var textDate: TextView
    private lateinit var calendar: Calendar
    private lateinit var simpleDateFormat: SimpleDateFormat

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<HomeWorkAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    private lateinit var textViewMonday : TextView
    private lateinit var textViewTuesday : TextView
    private lateinit var textViewWednesday : TextView
    private lateinit var textViewThursday : TextView
    private lateinit var textViewFriday : TextView
    private lateinit var textViewSaturday : TextView

    private var selectedDay : String = Constants.MONDAY

    var Date: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.fragment_home_work, container, false)
        setupView()
        textDate = currentView.findViewById(R.id.textViewDateMonthYear_homework)
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd MMMM,yyyy")
        Date = simpleDateFormat.format(calendar.time)
        textDate.text = Date
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


        return currentView
    }

    private fun setupView() {
        textViewMonday = currentView.findViewById(R.id.textView_monday_homework)
        textViewTuesday = currentView.findViewById(R.id.textView_tuesday_homework)
        textViewWednesday = currentView.findViewById(R.id.textView_wednesday_homework)
        textViewThursday = currentView.findViewById(R.id.textView_thursday_homework)
        textViewFriday = currentView.findViewById(R.id.textView_friday_homework)
        textViewSaturday = currentView.findViewById(R.id.textView_saturday_homework)

        recycler_adaptar = currentView.findViewById(R.id.homework_recyclerView)
        layoutManager = LinearLayoutManager(context)
        recycler_adaptar.layoutManager = layoutManager

        adapter = HomeWorkAdapter(context!!)
        recycler_adaptar.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeWorkFragment().apply {
            }
    }
}