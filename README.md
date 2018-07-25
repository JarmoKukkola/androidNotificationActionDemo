# Android Notification Action Demo
Demonstrating a weird behaviour with Android notification actions.

Long variable is included to notification action (line 34 of MainActivity.kt) and read after notification action clicked (line 16 of NotificationBroadcastReceiver.kt).

If you make several notifications by clicking the button and then press the action button to read the variable, the variable is not updated.

It seems that the value of the read long variable, is always the original long variable that was created on first click of the button.

This happens even after clearing the notifications and killing the app from task manager.

Related to Stack Overflow question: https://stackoverflow.com/questions/51518084/updating-extra-data-on-notification-intents-on-android
