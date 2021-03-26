package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.repositories.DownloadRepository
import com.brixham.admity.repositories.FaqRepository

class DownloadViewModelFactory(private val downloadRepository: DownloadRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DownloadViewModel(downloadRepository) as T
    }
}