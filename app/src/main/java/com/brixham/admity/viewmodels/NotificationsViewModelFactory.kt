package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.repositories.NotificationsRepository

class NotificationsViewModelFactory(private val notificationsRepository: NotificationsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotificationsViewModel(notificationsRepository) as T
    }
}