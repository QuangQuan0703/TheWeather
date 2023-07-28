package com.example.theweather.domain.location

import android.app.Application
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient


interface LocationCheck {
    suspend fun getCurrentLocationDevice(): Location?
    fun requestUpdate()
}