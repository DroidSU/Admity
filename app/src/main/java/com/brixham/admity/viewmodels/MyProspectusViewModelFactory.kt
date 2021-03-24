package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.repositories.MyProspectusRepository
import com.brixham.admity.repositories.NotificationsRepository

class MyProspectusViewModelFactory(private val myProspectusRepository: MyProspectusRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MyProspectusViewModel(myProspectusRepository) as T
    }
}