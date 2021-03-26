package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.repositories.GuardianCallRepository
import com.brixham.admity.repositories.GuardianMeetingRepository

class GuardianMeetingViewModelFactory(private val guardianMeetingRepository: GuardianMeetingRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GuardianMeetingViewModel(guardianMeetingRepository) as T
    }
}