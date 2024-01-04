import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import event.EventPublisher
import event.ThreadEvent

/**
 * Main function which is called on every device
 */
@Composable
fun App() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Loading) } // Screen Managing

    var test = 1
    if(test == 2)
        EventPublisher(ThreadEvent.TestEvent)
    Text("abcd")

    //Decide the Screen that is shown
    /*when(currentScreen){
        is Screen.Loading ->
    }*/
}


/**
 * Screens objects
 *
 * @object Loading -> Appears when loading
 */
sealed class Screen {
    data object Loading: Screen()
}