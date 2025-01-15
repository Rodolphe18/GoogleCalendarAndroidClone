package dev.baseio.libjetcalendar.monthly

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarTypography
import dev.baseio.libjetcalendar.data.JetDay
import dev.baseio.libjetcalendar.data.JetMonth
import dev.baseio.libjetcalendar.data.dayNames
import dev.baseio.libjetcalendar.weekly.JetCalendarWeekView
import java.time.DayOfWeek
import java.time.LocalDate

@Composable
fun JetCalendarMonthlyView(
  jetMonth: JetMonth,
  onDateSelected: (JetDay) -> Unit,
  selectedDate: JetDay,
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(start = 4.dp, end = 4.dp),
    verticalArrangement = Arrangement.SpaceAround,
  ) {
    jetMonth.monthWeeks.forEach { week ->
      JetCalendarWeekView(
        modifier = Modifier.fillMaxWidth(),
        week = week,
        onDateSelected = onDateSelected,
        selectedDates = selectedDate
      )
    }
  }
}

data class  CalendarInput(val day:Int, val todos:List<String> = emptyList())

@Composable
fun CalendarDate(modifier: Modifier = Modifier, calendarInput: CalendarInput) {
  calendarInput.todos.indices
  val currentMonth = LocalDate.now().month
  val totalDays = currentMonth.length(LocalDate.now().isLeapYear)
  val textMeasure = rememberTextMeasurer()

  Canvas(modifier = Modifier.fillMaxWidth().height(300.dp)){
    val width = size.width
    val height = size.height

    val daysInWeek = 7
    val totalRows = (totalDays + daysInWeek) / 7

    val boxHeight = height / totalRows
    val boxWidth = width / daysInWeek

    for(days in 1..totalDays) {
      val row = (days - 1) / daysInWeek
      val column = (days - 1) % daysInWeek

      val x = column * boxWidth
      val y = row * boxHeight

      drawRect(color = Color.Gray, topLeft = Offset(x,y), size = Size(boxWidth, boxHeight))
      drawText(textMeasure, text = "$days", topLeft = Offset(x + boxWidth/3, y+boxHeight/2.5f))
    }

  }

}


@Composable
fun WeekNames(dayOfWeek: DayOfWeek) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 16.dp, end = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    dayNames(dayOfWeek = dayOfWeek).forEach {
      Box(
        modifier = Modifier
          .padding(2.dp),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = it, modifier = Modifier.padding(2.dp),
          textAlign = TextAlign.Center,
        )
      }

    }
  }
}