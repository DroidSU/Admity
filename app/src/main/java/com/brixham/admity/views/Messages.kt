package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adaptars.MsgRecyclerAdapter
import com.brixham.admity.adaptars.RecyclerAdapter

class Messages : AppCompatActivity() {
    private lateinit var backImgMsg: ImageView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MsgRecyclerAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        backImgMsg = findViewById(R.id.imgBackmsg)
        backImgMsg.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
            Intent.FLAG_ACTIVITY_CLEAR_TASK
            Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        })
        recycler_adaptar = findViewById(R.id.recyclerMesssage)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = MsgRecyclerAdapter()
        recycler_adaptar.adapter = adapter

    }
}