package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.repositories.InstituteProfileRepository
import com.brixham.admity.repositories.StudentProfileDataRepository

class InstituteProfileViewModelFactory(private val instituteProfileRepository: InstituteProfileRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InstituteProfileViewModel(instituteProfileRepository) as T
    }
}