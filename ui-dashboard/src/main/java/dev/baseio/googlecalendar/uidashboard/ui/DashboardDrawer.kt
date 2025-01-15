package dev.baseio.googlecalendar.uidashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.baseio.googlecalendar.GoogleCalendarClone.R

@Composable
fun DashboardDrawer() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.8f)
            .background(Color.White)
            .padding(top = 56.dp),
    ) {
        Column {
            DrawerHeader()
            DrawerContent()
        }
    }
}


@Composable
private fun DrawerHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Calendar", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
    }
}

@Composable
private fun DrawerContent() {
    Column(modifier = Modifier.padding(12.dp)) {
        HorizontalDivider()
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.White),
            leadingContent = {
                Icon(painterResource(R.drawable.ic_view_agenda), null)
            },
            headlineContent = {
                Text(text = "Agenda")
            })
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.White),
            leadingContent = {
                Icon(painterResource(R.drawable.ic_calendar_view_day), null)
            },
            headlineContent = {
                Text(text = "Journée")
            })
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.White),
            leadingContent = {
                Icon(painterResource(R.drawable.ic_calendar_view_week), null)
            },
            headlineContent = {
                Text(text = "Semaine")
            })
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.White),
            leadingContent = {
                Icon(painterResource(R.drawable.ic_calendar_view_month), null)
            },
            headlineContent = {
                Text(text = "Mois")
            })
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.White),
            leadingContent = {
                Icon(painterResource(R.drawable.ic_calendar_month), null)
            },
            headlineContent = {
                Text(text = "An")
            })
        HorizontalDivider()
        ListItem(
            colors = ListItemDefaults.colors(containerColor = Color.White),
            leadingContent = {
                Icon(painterResource(R.drawable.ic_birthday), null)
            },
            headlineContent = {
                Text(text = "Anniversaire")
            })
      }
}
