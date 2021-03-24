package com.brixham.admity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brixham.admity.repositories.FaqRepository
import com.brixham.admity.repositories.NoticeRepository

class FaqViewModelFactory(private val faqRepository: FaqRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FaqViewModel(faqRepository) as T
    }
}