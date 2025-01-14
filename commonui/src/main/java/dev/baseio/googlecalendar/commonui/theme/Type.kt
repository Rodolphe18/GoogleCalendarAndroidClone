package dev.baseio.googlecalendar.commonui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.baseio.googlecalendar.GoogleCalendarClone.R

// Set of Material typography styles to start with

val slackFontFamily =
  FontFamily(
    Font(R.font.googlesanstextmedium, weight = FontWeight.Bold),
    Font(R.font.googlesansregular, weight = FontWeight.Light),
    Font(R.font.googlesansregular)
  )

val GoogleCalendarTypography = Typography(
  defaultFontFamily = slackFontFamily,
)