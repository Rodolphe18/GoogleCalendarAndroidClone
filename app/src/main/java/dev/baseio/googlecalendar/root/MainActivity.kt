package dev.baseio.googlecalendar.root

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.baseio.googlecalendar.navigator.ComposeNavigator
import dev.baseio.googlecalendar.navigator.GoogleCalendar
import dev.baseio.googlecalendar.uidashboard.nav.dashboardNavigation
import dev.baseio.googlecalendar.uionboarding.nav.onboardingNavigation
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var composeNavigator: ComposeNavigator

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      val navController = rememberNavController()
      LaunchedEffect(Unit) {
        composeNavigator.handleNavigationCommands(navController)
      }
        NavHost(
          navController = navController,
          startDestination = GoogleCalendar.Dashboard.name,
        ) {
          onboardingNavigation(composeNavigator)
          dashboardNavigation(composeNavigator)
        }
    }
  }

}

