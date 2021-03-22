package com.brixham.admity.repositories

import com.brixham.admity.models.HolidayResponseModel
import com.brixham.admity.models.StudentProfileResponseModel
import com.brixham.admity.network.Result

interface HolidayRepository {
    suspend fun getHoliday(authToken: String): Result<HolidayResponseModel>
}