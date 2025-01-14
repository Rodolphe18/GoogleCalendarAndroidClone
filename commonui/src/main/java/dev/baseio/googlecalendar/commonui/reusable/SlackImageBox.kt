package dev.baseio.googlecalendar.commonui.reusable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarColorProvider
import dev.baseio.googlecalendar.commonui.theme.GoogleCalendarSurface

@Composable
fun SlackImageBox(modifier: Modifier, imageUrl: String) {
  AsyncImage(
    modifier = modifier,
    model = ImageRequest.Builder(LocalContext.current)
      .data(imageUrl)
      .build(),
    contentDescription = null
  )
}

@Composable
fun SlackOnlineBox(imageUrl: String) {
  ConstraintLayout(Modifier.size(34.dp)) {
    val (image, indicator) = createRefs()
    SlackImageBox(
      Modifier
        .size(28.dp)
        .constrainAs(image) {
          top.linkTo(parent.top)
          bottom.linkTo(parent.bottom)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
        }, imageUrl
    )
    GoogleCalendarSurface(shape = CircleShape,
      border = BorderStroke(3.dp, color = GoogleCalendarColorProvider.colors.uiBackground),
      modifier = Modifier
        .constrainAs(indicator) {
          bottom.linkTo(parent.bottom)
          end.linkTo(parent.end)
        }
        .size(14.dp)){
      Box(
        modifier = Modifier
          .size(12.dp)
          .clip(CircleShape)
          .background(Color.Green)

      )
    }

  }
}


@Preview
@Composable
fun PrevSlackOnlineBox() {
  SlackOnlineBox(
    imageUrl = "https://avatars.slack-edge.com/2018-07-20/401750958992_1b07bb3c946bc863bfc6_88.png"
  )
}