package com.brixham.admity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brixham.admity.R
import com.brixham.admity.adapters.MsgRecyclerAdapter
import com.brixham.admity.adapters.RecyclerAdapter



class FragmentMessage : Fragment() {

    private lateinit var currentView: View
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MsgRecyclerAdapter.ViewHolder>? = null
    private lateinit var recycler_adaptar : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentView = inflater.inflate(R.layout.fragment_message, container, false)

        recycler_adaptar = currentView.findViewById(R.id.message_recycler_view)
        layoutManager = LinearLayoutManager(context)
        recycler_adaptar.layoutManager = layoutManager
        adapter = MsgRecyclerAdapter()
        recycler_adaptar.adapter = adapter

        return currentView
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentMessage().apply {
            }
    }
}