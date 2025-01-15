package dev.baseio.googlecalendar.uionboarding.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarColorProvider
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarSurface
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarTheme
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarTypography
import dev.baseio.googlecalendar.navigator.ComposeNavigator
import dev.baseio.googlecalendar.navigator.GoogleCalendar


@Composable
fun GettingStartedUI(composeNavigator: ComposeNavigator) {
  GoogleCalendarTheme {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
      backgroundColor = GoogleCalendarColorProvider.colors.uiBackground,
      contentColor = GoogleCalendarColorProvider.colors.textPrimary,
      modifier = Modifier.statusBarsPadding(), scaffoldState = scaffoldState, snackbarHost = {
        scaffoldState.snackbarHostState
      }
    ) { innerPadding ->
      Box(modifier = Modifier.padding(innerPadding)) {
        GoogleCalendarSurface(
          modifier = Modifier
            .padding(12.dp)
        ) {
          Column {
            OnboardingPager(composeNavigator)
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun OnboardingPager(composeNavigator: ComposeNavigator) {
  Box(Modifier.fillMaxSize()) {
    val pagerState = rememberPagerState()
    HorizontalPager(count = 2, state = pagerState) { pagerScope ->
      when (pagerScope) {
        0 -> OnbSecondPage()
      }
    }

    Box(
      modifier = Modifier.Companion
        .align(Alignment.Center)
        .padding(16.dp)
    ) {
        GotItButton(composeNavigator)
    }
  }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun PagerIndicators(pagerState: PagerState) {
  Box(Modifier.padding(16.dp)) {
    HorizontalPagerIndicator(
      pagerState = pagerState,
      activeColor = GoogleCalendarColorProvider.colors.buttonColor
    )
  }
}

@Composable
private fun GotItButton(composeNavigator: ComposeNavigator) {
  OutlinedButton(
    onClick = {
      composeNavigator.navigate(GoogleCalendar.Dashboard.name)
    },
    shape = RoundedCornerShape(50), // = 50% percent
    colors = ButtonDefaults.buttonColors(backgroundColor = GoogleCalendarColorProvider.colors.buttonColor)
  ) {
    Text(
      modifier = Modifier.padding(16.dp),
      text = "Got it",
      style = GoogleCalendarTypography.subtitle1.copy(GoogleCalendarColorProvider.colors.buttonTextColor)
    )
  }
}

@Composable
private fun OnbSecondPage() {
  Column(
    verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxHeight()
      .fillMaxWidth()
  ) {
    Spacer(Modifier.padding(8.dp))
   // ImageDrawable(R.drawable.ic_eye)
    Spacer(Modifier.padding(8.dp))
    GoogleCalendarOnboardingText("Easy to scan and lovely to\\nlook at", "Schedule View puts images and maps on\\nyour calendar.")
    Spacer(Modifier.padding(8.dp))
  }
}

@Composable
private fun OnbFirstPage() {
  Column(
    verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxHeight()
      .fillMaxWidth()
  ) {
    Spacer(Modifier.padding(8.dp))
 //   ImageDrawable(R.drawable.gettingstarted)
    Spacer(Modifier.padding(8.dp))
    GoogleCalendarOnboardingText("Google Calendar", "make the most of everyday")
    Spacer(Modifier.padding(8.dp))
  }
}

@Composable
private fun GoogleCalendarOnboardingText(primary: String, secondary:String) {
  var expanded by remember { mutableStateOf(false) }
  LaunchedEffect(Unit) {
    expanded = !expanded
  }
  AnimatedVisibility(
    expanded, enter = fadeIn(
      // Fade in with the initial alpha of 0.3f.
      initialAlpha = 0.3f, animationSpec = tween(durationMillis = 2000)
    )
  ) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
      Text(
        text = primary,
        style = GoogleCalendarTypography.h5.copy(color = GoogleCalendarColorProvider.colors.textPrimary),
        textAlign = TextAlign.Center
      )
      Spacer(modifier = Modifier.height(24.dp))
      Text(
        text = secondary,
        style = GoogleCalendarTypography.subtitle1.copy(color = GoogleCalendarColorProvider.colors.textSecondary),
        textAlign = TextAlign.Center
      )
    }
  }

}

@Composable
private fun ImageDrawable(id: Int) {
  Image(
    painter = painterResource(id = id),
    contentDescription = "Logo",
    Modifier
  )
}

