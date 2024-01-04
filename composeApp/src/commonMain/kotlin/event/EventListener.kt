package event

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import utils.CommonLogger


@Composable
fun EventPublisher(
    eventType: ThreadEvent
) {
    val eventBus = remember { EventBus() }

    when(eventType){
        //TestEvent
        is ThreadEvent.TestEvent -> {
            eventBus.subscribe(eventType){
                val commonLogger = CommonLogger()
                commonLogger.log("ABCD")
            }
            eventBus.publish(eventType)
        }
    }
}