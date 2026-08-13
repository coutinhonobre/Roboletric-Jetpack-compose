package com.vocablend.myapplication.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel(
    initialCount: Int = 0
) : ViewModel() {

    private val _state = MutableStateFlow(CounterContract.State(count = initialCount))
    val state: StateFlow<CounterContract.State> = _state.asStateFlow()

    fun onEvent(event: CounterContract.Event) {
        when (event) {
            CounterContract.Event.Increment -> _state.update { it.copy(count = it.count + 1) }
        }
    }

    companion object {
        // Factory manual, sem framework de injeção de dependência (Hilt/Koin).
        // Necessário aqui porque o construtor recebe argumentos.
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return CounterViewModel(initialCount = 0) as T
            }
        }
    }
}
