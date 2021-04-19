package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.ExamAdapter
import com.brixham.admity.adapters.PaymentHistoryAdapter

class PaymentHistoryActivity : AppCompatActivity() {

    private lateinit var backImgPaymentHistory: ImageView
    private lateinit var imgPaymentHistoryBellIcon: ImageView
    private lateinit var textViewHeader: TextView

    private lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_history)
        setUpViews()
    }

    private fun setUpViews() {
        backImgPaymentHistory = findViewById(R.id.imgIcLeftArrow)
        textViewHeader = findViewById(R.id.toolbar_header)

        textViewHeader.text = getString(R.string.payment_history)
        backImgPaymentHistory.visibility = View.VISIBLE
        textViewHeader.visibility = View.VISIBLE

        backImgPaymentHistory.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.payment_history_recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = PaymentHistoryAdapter()
        recyclerView.adapter = adapter
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}