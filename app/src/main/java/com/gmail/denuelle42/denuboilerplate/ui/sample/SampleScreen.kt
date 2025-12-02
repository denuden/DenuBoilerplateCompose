package com.gmail.denuelle42.denuboilerplate.ui.sample

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.Navigation
import com.gmail.denuelle42.denuboilerplate.navigation.NavigationScreens
import com.gmail.denuelle42.denuboilerplate.ui.common.dialog.ErrorDialog
import com.gmail.denuelle42.denuboilerplate.utils.ComposableLifecycle
import com.gmail.denuelle42.denuboilerplate.utils.ObserveAsEvents
import com.gmail.denuelle42.denuboilerplate.utils.OneTimeEvents
import com.gmail.denuelle42.denuboilerplate.utils.SnackBarController
import com.gmail.denuelle42.denuboilerplate.utils.handleInputError
import kotlinx.coroutines.launch

@Composable
fun SampleScreen(
    onPopBackStack : () -> Unit,
    onNavigate : (NavigationScreens) -> Unit,
    viewModel: SampleViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val screenState by viewModel.stateFlow.collectAsStateWithLifecycle()

    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    ErrorDialog(
        text = errorMessage,
        showDialog = showErrorDialog
    ) {
        showErrorDialog = false
    }
    //One time events listener
    ObserveAsEvents(flow = viewModel.channel) { event ->
        when (event) {
            is OneTimeEvents.OnNavigate -> onNavigate(event.route)
            OneTimeEvents.OnPopBackStack -> onPopBackStack()
            is OneTimeEvents.ShowSnackbar ->  {
                scope.launch {
                    SnackBarController.sendEvent(event.snackbarEvent)
                }
            }
            is OneTimeEvents.ShowToast -> {
                Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
            }
            is OneTimeEvents.ShowInputError -> {
                showErrorDialog = true
                errorMessage = handleInputError(event.errors)
            }
        }
    }

    ComposableLifecycle { _, lifecycleEvent ->
        when (lifecycleEvent) {
            Lifecycle.Event.ON_RESUME -> {
            }

            else -> Unit
        }
    }

    SampleScreenContent(uiState = screenState, onEvent = viewModel::onEvent)
}

@Composable
fun SampleScreenContent(
    modifier: Modifier = Modifier,
    uiState: SampleScreenState,
    onEvent: (SampleScreenEvents) -> Unit
) {

}