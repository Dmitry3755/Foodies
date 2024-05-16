package com.example.fooddelivery.dependency_injection.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FoodiesApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}