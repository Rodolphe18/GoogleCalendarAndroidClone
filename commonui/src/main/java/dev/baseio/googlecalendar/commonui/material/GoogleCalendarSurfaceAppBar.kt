package dev.baseio.googlecalendar.commonui.material

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarSurface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleCalendarSurfaceAppBar(
  title: @Composable () -> Unit,
  modifier: Modifier = Modifier,
  navigationIcon: @Composable () -> Unit,
  actions: @Composable RowScope.() -> Unit = {},
  backgroundColor: Color = MaterialTheme.colorScheme.primary,
  contentColor: Color = contentColorFor(backgroundColor),
  elevation: Dp = 2.dp
) {
  GoogleCalendarSurface(
    color = backgroundColor,
    contentColor = contentColor,
    elevation = elevation
  ) {
    TopAppBar(
     title = title, modifier =  modifier, navigationIcon = navigationIcon, actions = actions, colors = TopAppBarColors(
            containerColor = backgroundColor,
            scrolledContainerColor = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface,
        )
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleCalendarSurfaceAppBar(
  modifier: Modifier = Modifier,
  backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
  contentColor: Color = contentColorFor(backgroundColor),
  elevation: Dp = 2.dp,
  content: @Composable RowScope.() -> Unit
) {
  GoogleCalendarSurface(
    color = backgroundColor,
    contentColor = contentColor,
    elevation = elevation
  ) {
    TopAppBar(title = { "g" },
      modifier =  modifier, navigationIcon = { } , actions = content, colors = TopAppBarColors(
        containerColor = backgroundColor,
        scrolledContainerColor = MaterialTheme.colorScheme.onSurface,
        navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
        titleContentColor = MaterialTheme.colorScheme.onSurface,
        actionIconContentColor = MaterialTheme.colorScheme.onSurface,
      )
    )
  }
}