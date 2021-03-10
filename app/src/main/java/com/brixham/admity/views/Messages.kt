package com.brixham.admity.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adaptars.MsgRecyclerAdapter
import com.brixham.admity.adaptars.RecyclerAdapter

class Messages : AppCompatActivity() {
    private lateinit var backImgMsg: ImageView
    private lateinit var imgMsgBellIcon: ImageView
    private lateinit var textViewMsg: TextView
    private lateinit var linearLayoutHomePage: LinearLayout
    private lateinit var linearLayoutHelpPage: LinearLayout

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MsgRecyclerAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        backImgMsg = findViewById(R.id.imgIcLeftArrow)
        imgMsgBellIcon = findViewById(R.id.imgHeaderBellIcon)
        textViewMsg = findViewById(R.id.textHeaderMessage)
        //linearLayoutHomePage = findViewById(R.id.linearLayout_homePage2)
        //linearLayoutHelpPage = findViewById(R.id.linearLayout_helpPage2)
        backImgMsg.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish()
        })
        linearLayoutHomePage.setOnClickListener(View.OnClickListener {
            var intent1: Intent = Intent(this, DashBoard::class.java)
            startActivity(intent1)
            finish()
        })
        linearLayoutHelpPage.setOnClickListener(View.OnClickListener {
            var intent2: Intent = Intent(this, HelpActivity::class.java)
            startActivity(intent2)
            finish()
        })
        backImgMsg.visibility = View.VISIBLE
        textViewMsg.visibility = View.VISIBLE
        imgMsgBellIcon.visibility = View.VISIBLE

        recycler_adaptar = findViewById(R.id.recyclerMesssage)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = MsgRecyclerAdapter()
        recycler_adaptar.adapter = adapter

    }
}