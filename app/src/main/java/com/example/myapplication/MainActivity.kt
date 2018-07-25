package com.example.myapplication

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity:AppCompatActivity() {

  override fun onCreate(savedInstanceState:Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  fun notify(v:View) {
    Log.d(this.localClassName,"Notify")
    val mBuilder = NotificationCompat.Builder(this,this.localClassName).setSmallIcon(android.R.drawable.btn_default).setContentTitle("note")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    mBuilder.setDefaults(Notification.DEFAULT_ALL).addAction(android.R.drawable.arrow_down_float,"test",getSnoozePendingIntent())
    val notificationManager = NotificationManagerCompat.from(this)
    notificationManager.notify(NotificationBroadcastReceiver.id,mBuilder.build())
  }

  private fun getSnoozePendingIntent():PendingIntent {
    val snoozeIntent = Intent(this,NotificationBroadcastReceiver::class.java)

    snoozeIntent.action = NotificationBroadcastReceiver.tag
    val time = System.currentTimeMillis()
    Log.d("TimeMillis before",time.toString())
    snoozeIntent.putExtra(NotificationBroadcastReceiver.timeTag,time)
    return PendingIntent.getBroadcast(this,0,snoozeIntent,0)
  }
}
