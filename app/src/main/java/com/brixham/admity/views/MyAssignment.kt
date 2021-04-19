package com.brixham.admity.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.EventAdapter
import com.brixham.admity.adapters.MyAssignmentAdapter

class MyAssignment : AppCompatActivity() {
    private lateinit var backImgAssignment: ImageView
    private lateinit var imgAssignmentBellIcon: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var assignmentSpinner: Spinner

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MyAssignmentAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_assignment)
        setupView()

    }

    private fun setupView() {
        backImgAssignment = findViewById(R.id.imgIcLeftArrow)
        imgAssignmentBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)


        textViewHeader.text = getString(R.string.my_assignment)
        backImgAssignment.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        recyclerView = findViewById(R.id.assignment_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MyAssignmentAdapter()
        recyclerView.adapter = adapter
        backImgAssignment.setOnClickListener {
            onBackPressed()
        }
        assignmentSpinner = findViewById(R.id.assignmentForm_spinner)
        val assignmentList = resources.getStringArray(R.array.AssignmentList)

        var adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, assignmentList
        )
        assignmentSpinner.adapter = adapter

        assignmentSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

                /*Toast.makeText(
                    this@EnquiryActivity,
                    getString(R.string.enquiry_type) + " " +
                            "" + languages[position], Toast.LENGTH_SHORT
                ).show()*/
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }  }



    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}