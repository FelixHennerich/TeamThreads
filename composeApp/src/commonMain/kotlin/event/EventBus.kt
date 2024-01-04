package event


class EventBus {
    private val subscribers = mutableMapOf<ThreadEvent, MutableList<() -> Unit>>()

    fun subscribe(eventType: ThreadEvent, subscriber: () -> Unit) {
        val subscribersList = subscribers[eventType] ?: mutableListOf()
        subscribersList.add(subscriber)
        subscribers[eventType] = subscribersList
    }

    fun publish(eventType: ThreadEvent) {
        val subscribersList = subscribers[eventType] ?: return
        subscribersList.forEach { it() }
    }
}
