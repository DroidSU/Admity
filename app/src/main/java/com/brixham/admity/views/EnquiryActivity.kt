package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.EnquiryFormAdapter
import com.brixham.admity.adapters.TransportAdapter

class EnquiryActivity : AppCompatActivity() {

    private lateinit var backImgEnquiry: ImageView
    private lateinit var imgEnquiryBellIcon: ImageView
    private lateinit var textViewHeader: TextView
    private lateinit var enquirySpinner: Spinner

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<EnquiryFormAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enquiry)

        setupView()
    }

    private fun setupView() {
        backImgEnquiry = findViewById(R.id.imgIcLeftArrow)
        imgEnquiryBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewHeader = findViewById(R.id.toolbar_header)


        textViewHeader.text = getString(R.string.enquiry_form)
        backImgEnquiry.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgEnquiry.setOnClickListener {
            onBackPressed()
        }
        recycler_adaptar = findViewById(R.id.enquiry_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager
        adapter = EnquiryFormAdapter()
        recycler_adaptar.adapter = adapter

        enquirySpinner = findViewById(R.id.enquiryForm_spinner)
        val enquiryList = resources.getStringArray(R.array.EnquiryList)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, enquiryList
        )
        enquirySpinner.adapter = adapter

        enquirySpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
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
            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}