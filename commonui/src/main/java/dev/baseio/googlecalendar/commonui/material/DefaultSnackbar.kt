package dev.baseio.googlecalendar.commonui.material

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarColorProvider
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarTypography

@Composable
fun DefaultSnackbar(
  snackbarHostState: SnackbarHostState,
  modifier: Modifier = Modifier,
  onDismiss: () -> Unit = { }
) {
  SnackbarHost(
    hostState = snackbarHostState,
    snackbar = { data ->
      Snackbar(
        content = {
          Text(
            text = data.visuals.message,
            style = GoogleCalendarTypography.body1,
            color = GoogleCalendarColorProvider.colors.textPrimary,
            )
        },
        action = {
          data.visuals.actionLabel?.let { actionLabel ->
            TextButton(onClick = onDismiss) {
              Text(
                text = actionLabel,
                color = GoogleCalendarColorProvider.colors.textPrimary,
                style = GoogleCalendarTypography.body2
              )
            }
          }
        },
        containerColor = Color.White
      )
    },
    modifier = modifier
      .fillMaxWidth()
      .wrapContentHeight(Alignment.Bottom)
  )
}