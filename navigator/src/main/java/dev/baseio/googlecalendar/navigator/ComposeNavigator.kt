package dev.baseio.googlecalendar.navigator.composenavigator

import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import dev.baseio.googlecalendar.navigator.ComposeNavigationCommand
import dev.baseio.googlecalendar.navigator.ComposeNavigator
import dev.baseio.googlecalendar.navigator.asFlow
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GoogleCalendarComposeNavigator @Inject constructor(): ComposeNavigator() {

  override fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)?) {
    val options = optionsBuilder?.let { navOptions(it) }
    navigationCommands.tryEmit(ComposeNavigationCommand.NavigateToRoute(route, options))
  }

  override fun navigateAndClearBackStack(route: String) {
    navigationCommands.tryEmit(ComposeNavigationCommand.NavigateToRoute(route, navOptions {
      popUpTo(0)
    }))
  }

  override fun popUpTo(route: String, inclusive: Boolean) {
    navigationCommands.tryEmit(ComposeNavigationCommand.PopUpToRoute(route, inclusive))
  }

  override fun <T> navigateBackWithResult(
    key: String,
    result: T,
    route: String?
  ) {
    navigationCommands.tryEmit(
      ComposeNavigationCommand.NavigateUpWithResult(
        key = key,
        result = result,
        route = route
      )
    )
  }

  override fun <T> observeResult(key: String, route: String?): Flow<T> {
    return navControllerFlow
      .filterNotNull()
      .flatMapLatest { navController ->
        val backStackEntry = route?.let { navController.getBackStackEntry(it) }
          ?: navController.currentBackStackEntry
        backStackEntry?.savedStateHandle?.let { savedStateHandle ->
          savedStateHandle.getLiveData<T>(key)
            .asFlow()
            .filter { it != null }
            .onEach {
              // Nullify the result to avoid resubmitting it
              savedStateHandle[key] = null
            }
        } ?: emptyFlow()
      }
  }


}