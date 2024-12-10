package com.gmail.denuelle42.denuboilerplate.ui.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmail.denuelle42.denuboilerplate.utils.OneTimeEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class SampleViewModel : ViewModel(){
    private val TAG = SampleViewModel::class.java.simpleName

    private val _channel = Channel<OneTimeEvents>()
    val channel = _channel.receiveAsFlow()

    private val _stateFlow = MutableStateFlow<SampleScreenState>(SampleScreenState())
    val stateFlow = _stateFlow.asStateFlow()

    fun onEvent(event : SampleScreenEvents) {
        when(event){
            is SampleScreenEvents.OnGetEvent -> {
                viewModelScope.launch {
                    _stateFlow.update {
                        it.copy(name = event.name)
                    }
                }
            }
        }
    }

    private fun sendEvent(event: OneTimeEvents) {
        viewModelScope.launch {
            _channel.send(event)
        }
    }
}