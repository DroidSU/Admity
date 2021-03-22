package com.brixham.admity.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.R
import com.brixham.admity.adapters.DashboardGridAdapter
import com.brixham.admity.models.DashboardGridModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.NetworkCallback
import com.brixham.admity.utilities.Constants
import com.brixham.admity.viewmodels.StudentProfileViewModel
import com.brixham.admity.viewmodels.StudentProfileViewModelFactory
import com.brixham.admity.views.DashBoard
import com.brixham.admity.views.HolidayActivity
import com.brixham.admity.views.RoutineActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.Internal.instance
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.KodeinPropertyDelegateProvider
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.KProperty


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(){

    private lateinit var currentView: View
    private lateinit var gridView: GridView
    private lateinit var textDate: TextView
    private lateinit var textTime: TextView
    private lateinit var calendar: Calendar
    private lateinit var simpleDateFormat: SimpleDateFormat
    private lateinit var simpleTimeFormat: SimpleDateFormat
    private lateinit var dashBoardTextName: TextView
    private lateinit var gridAdapter : DashboardGridAdapter
    private lateinit var listOfGridModels : ArrayList<DashboardGridModel>

    var Date: String? = null
    var Time: String? = null


    private var TAG = HomeFragment::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.fragment_home, container, false)

        initGridModules()

        textDate = currentView.findViewById(R.id.textDateMonthYear)
        textTime = currentView.findViewById(R.id.textTime)
        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        simpleTimeFormat = SimpleDateFormat("HH:mm")
        Date = simpleDateFormat.format(calendar.time)
        Time = simpleTimeFormat.format(calendar.time)
        textDate.text = Date
        textTime.text = Time

        dashBoardTextName = currentView.findViewById(R.id.textView_salutation)

        gridView = currentView.findViewById(R.id.gridView_home)
        gridAdapter = DashboardGridAdapter(context, R.layout.item_dashboard_grid, listOfGridModels)
        gridView.adapter = gridAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            if (position == 0) {
                startActivity(Intent(activity, RoutineActivity::class.java))
            } else if (position == 9) {
                startActivity(Intent(activity, HolidayActivity::class.java))
            }
        }

        dashBoardTextName.text = arguments?.getString(STUDENT_NAME)

        return currentView
    }

    override fun onStart() {
        super.onStart()
        val sharedPref= context!!.getSharedPreferences(Constants.SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    }


    private fun initGridModules() {
        listOfGridModels = ArrayList()

        listOfGridModels.add(DashboardGridModel(R.drawable.present, "Routine"))
        listOfGridModels.add(DashboardGridModel(R.drawable.syllabus, "Syllabus"))
        listOfGridModels.add(DashboardGridModel(R.drawable.teacher, "Faculties"))
        listOfGridModels.add(DashboardGridModel(R.drawable.exam, "Exam"))
        listOfGridModels.add(DashboardGridModel(R.drawable.attendance, "Attendance"))
        listOfGridModels.add(DashboardGridModel(R.drawable.fee, "Fees"))
        listOfGridModels.add(DashboardGridModel(R.drawable.assignment, "Assignment"))
        listOfGridModels.add(DashboardGridModel(R.drawable.notice, "Notice"))
        listOfGridModels.add(DashboardGridModel(R.drawable.event, "Event"))
        listOfGridModels.add(DashboardGridModel(R.drawable.holiday, "Holiday"))
        listOfGridModels.add(DashboardGridModel(R.drawable.leave, "Leave"))
        listOfGridModels.add(DashboardGridModel(R.drawable.parents, "Parents"))



    }

    companion object{
        fun newInstance(name : String) : HomeFragment{
            val fragment = HomeFragment()

            val bundle = Bundle().apply {
                putString(STUDENT_NAME, name)
            }

            fragment.arguments = bundle

            return fragment
        }

        private const val STUDENT_NAME = "student_name"
    }
}


