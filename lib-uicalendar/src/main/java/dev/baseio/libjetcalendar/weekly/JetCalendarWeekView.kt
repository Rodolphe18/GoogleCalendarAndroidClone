package dev.baseio.libjetcalendar.weekly

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarColorProvider
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarTypography
import dev.baseio.libjetcalendar.data.JetDay
import dev.baseio.libjetcalendar.data.JetWeek

@Composable
fun JetCalendarWeekView(
  modifier: Modifier,
  week: JetWeek,
  onDateSelected: (JetDay) -> Unit,
  selectedDates: JetDay,
) {
  LazyRow(
    modifier = modifier
      .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    items(week.days) { date ->
      Box(
        modifier = Modifier
          .clip(CircleShape)
          .size(40.dp)
          .clickable {
            if (date.isPartOfMonth) {
              onDateSelected(date)
            }
          }
          .background(bgColor(selectedDates, date)),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = date.date.dayOfMonth.toString(),
          textAlign = TextAlign.Center,
          style = GoogleCalendarTypography.subtitle1
            .copy(color = if (date.isPartOfMonth) GoogleCalendarColorProvider.colors.appBarTextTitleColor else Color.Transparent)
        )
      }
    }
  }
}

@Composable
private fun bgColor(
  selectedDates: JetDay,
  date: JetDay
) =
  if (selectedDates.date.isEqual(date.date)) GoogleCalendarColorProvider.colors.buttonColor else Color.Transparent