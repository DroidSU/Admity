package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.repositories.ChangePasswordRepository
import com.brixham.admity.repositories.StudentProfileDataRepository

class StudentProfileViewModelFactory(private val studentprofileRepository: StudentProfileDataRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentProfileViewModel(studentprofileRepository) as T
    }
}