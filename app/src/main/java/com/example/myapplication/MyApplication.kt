package com.example.myapplication

import android.app.Application
import android.content.IntentFilter

class MyApplication:Application() {
  override fun onCreate() {
    super.onCreate()
    registerReceiver(NotificationBroadcastReceiver(),IntentFilter(NotificationBroadcastReceiver.tag))
  }
}