package event

sealed interface ThreadEvent {
    object TestEvent: ThreadEvent

    class RegisterErrorMessageUpdate(val message: String): ThreadEvent

}