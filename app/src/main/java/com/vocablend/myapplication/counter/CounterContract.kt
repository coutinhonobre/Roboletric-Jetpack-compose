package com.vocablend.myapplication.counter

object CounterContract {

    data class State(
        val count: Int = 0
    )

    sealed interface Event {
        data object Increment : Event
    }
}
