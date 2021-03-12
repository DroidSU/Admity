package com.brixham.admity.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.ChatRecyclerAdapter

class ChatAtivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_ativity)

        recycler_adaptar = findViewById(R.id.recylerChat)

        layoutManager = LinearLayoutManager(this)
        recycler_adaptar.layoutManager = layoutManager


        adapter = ChatRecyclerAdapter()
        recycler_adaptar.adapter = adapter
    }


}