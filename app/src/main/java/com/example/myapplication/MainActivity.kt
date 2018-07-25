package com.example.myapplication

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
    val time = System.currentTimeMillis()
    val mBuilder = NotificationCompat
        .Builder(this,this.localClassName)
        .setSmallIcon(android.R.drawable.btn_default)
        .addAction(android.R.drawable.arrow_down_float,"test",getSnoozePendingIntent(time))
    NotificationManagerCompat.from(this).notify(time.toInt(),mBuilder.build())
  }

  private fun getSnoozePendingIntent(time:Long):PendingIntent {
    val snoozeIntent = Intent(this,NotificationBroadcastReceiver::class.java)
    Log.d("TimeMillis before",time.toString())
    snoozeIntent.putExtra(NotificationBroadcastReceiver.timeTag,time)
    return PendingIntent.getBroadcast(this,0,snoozeIntent,0)
  }
}
