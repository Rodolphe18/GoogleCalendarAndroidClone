package dev.baseio.googlecalendar.uidashboard.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarColorProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardAppBar(toggleDrawer: () -> Unit,onToggleMonth: () -> Unit) {
  TopAppBar(
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = GoogleCalendarColorProvider.colors.appBarColor,
      navigationIconContentColor = GoogleCalendarColorProvider.colors.appBarIconColor,
      titleContentColor = GoogleCalendarColorProvider.colors.appBarTextTitleColor,
      actionIconContentColor = GoogleCalendarColorProvider.colors.appBarIconColor
    ), title = {
      CalendarMonthPicker {
        onToggleMonth.invoke()
      }
    }, actions = {
      IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Search, contentDescription = null)
      }
      IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Settings, contentDescription = null)
      }
      IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Person, contentDescription = null)
      }
    }, navigationIcon = {
      IconButton(onClick = {
        toggleDrawer.invoke()
      }) {
        Icon(
          imageVector = Icons.Filled.Menu,
          contentDescription = "null"
        )
      }
    }
  )
}


@Composable
fun CalendarMonthPicker(onToggleMonth: () -> Unit) {
  Row(Modifier.clickable {
    onToggleMonth.invoke()
  }, verticalAlignment = Alignment.CenterVertically) {
    Text("February")
    Icon(
      Icons.Filled.ArrowDropDown,
      contentDescription = null,
      modifier = Modifier.padding(start = 4.dp)
    )
  }
}
