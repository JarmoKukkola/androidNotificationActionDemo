package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationManagerCompat

class NotificationBroadcastReceiver:BroadcastReceiver() {
  companion object {
    const val timeTag = "timeTag"
  }

  override fun onReceive(context:Context,intent:Intent) {
    val time = intent.getLongExtra(timeTag,0)
    Log.d("TimeMillis after",time.toString())
    NotificationManagerCompat.from(context).cancel(time.toInt())
  }
}