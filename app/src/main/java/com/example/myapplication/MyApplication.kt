package com.example.myapplication

import android.app.Application
import android.content.IntentFilter

class MyApplication:Application() {
  override fun onCreate() {
    super.onCreate()
    val notificationBroadcastReceiver=NotificationBroadcastReceiver()
    registerReceiver(notificationBroadcastReceiver,IntentFilter(NotificationBroadcastReceiver.tag))
  }
}