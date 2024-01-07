import account.data.mapUserString
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.external.RESTfulManager
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import di.AppModule
import event.ThreadEvent
import event.ThreadViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import utils.CommonLogger

/**
 * Main function which is called on every device
 */
@Composable
fun App(
    appModule: AppModule
) {
    // Screen Managing
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Loading) }

    //state managing
    val viewModel = getViewModel(
        key = "main-login-screen",
        factory = viewModelFactory {
            ThreadViewModel(
                localDataStorageManager = appModule.localDataSource
            )
        }
    )
    val state by viewModel.state.collectAsState()


    /**
     * TESTS
     */
    Text("Abcd")

    Text(
        state.testvalue,
        modifier = Modifier.padding(100.dp)
    )
    GlobalScope.launch {
        delay(10000)
        viewModel.onEvent(ThreadEvent.TestEvent)
    }

    val commonLogger = CommonLogger()

    val resTfulManager = RESTfulManager()
    val keylist = listOf<String>("uuid", "name", "age")
    val valuelist = listOf<String>("23423434","felix Hennerich", "12")
    GlobalScope.launch {
        //resTfulManager.editOrCreateEntryWithKeys(keylist, valuelist)


        commonLogger.log(mapUserString(resTfulManager.getEntryByKey("uuid", "23423434")).toString())
    }

    /**
     *
     */

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