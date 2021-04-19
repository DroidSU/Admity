package com.brixham.admity.network

import android.view.View
import android.widget.FrameLayout
import com.brixham.admity.models.TimeLine

interface TimeLineViewCallback<in T : TimeLine> {
    fun onBindView(model: T, container: FrameLayout, position: Int): View
}