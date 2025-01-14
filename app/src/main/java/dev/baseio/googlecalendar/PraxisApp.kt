package dev.baseio.googlecalendar

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class GoogleCalendarClone : Application() {

  override fun onCreate() {
    super.onCreate()

      Timber.plant(Timber.DebugTree())
  }
}
