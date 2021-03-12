package com.brixham.admity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.brixham.admity.R
import com.brixham.admity.adapters.DashboardGridAdapter
import com.brixham.admity.models.DashboardGridModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var currentView: View
    private lateinit var gridView: GridView
    private lateinit var gridAdapter : DashboardGridAdapter
    private lateinit var listOfGridModels : ArrayList<DashboardGridModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        // Inflate the layout for this fragment
        currentView = inflater.inflate(R.layout.fragment_home, container, false)

        initGridModules()

        gridView = currentView.findViewById(R.id.gridView_home)
        gridAdapter = DashboardGridAdapter(context, R.layout.item_dashboard_grid, listOfGridModels)
        gridView.adapter = gridAdapter

        return currentView
    }

    private fun initGridModules() {
        listOfGridModels = ArrayList()

        listOfGridModels.add(DashboardGridModel(R.drawable.syllabus, "Syllabus"))
        listOfGridModels.add(DashboardGridModel(R.drawable.school, "About"))
        listOfGridModels.add(DashboardGridModel(R.drawable.teacher, "Faculties"))
        listOfGridModels.add(DashboardGridModel(R.drawable.attendance, "Attendance"))
        listOfGridModels.add(DashboardGridModel(R.drawable.fee, "Fees"))
        listOfGridModels.add(DashboardGridModel(R.drawable.leave, "Leave"))
        listOfGridModels.add(DashboardGridModel(R.drawable.present, "Class"))
        listOfGridModels.add(DashboardGridModel(R.drawable.present, "Insight"))
        listOfGridModels.add(DashboardGridModel(R.drawable.event, "Event"))
        listOfGridModels.add(DashboardGridModel(R.drawable.holiday, "Holiday"))
        listOfGridModels.add(DashboardGridModel(R.drawable.notice, "Notice"))
        listOfGridModels.add(DashboardGridModel(R.drawable.parents, "Parents"))
    }

    companion object{
        fun newInstance() = HomeFragment().apply {
        }
    }
}