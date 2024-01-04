package event

sealed interface ThreadEvent {
    object TestEvent: ThreadEvent

}