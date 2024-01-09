import account.User
import account.creation.AccountCreationManager
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
import company.Company
import data.external.APIType
import data.external.RESTfulManager
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import di.AppModule
import event.ThreadEvent
import event.ThreadViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.view.RegisterScreen
import utils.CommonLogger
import utils.CryptoManager
import utils.exception.ExceptionHandler

/**
 * Main function which is called on every device
 */
@Composable
fun App(
    appModule: AppModule
) {
    // Screen Managing
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Register) }

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

    val commonLogger = CommonLogger()
    val fetcher = ExceptionHandler()
    val acc = AccountCreationManager()
    val company = Company("ufeu893474huef")


    val resTfulManager = RESTfulManager()
    val keylist = listOf<String>("uuid", "name", "age")
    val valuelist = listOf<String>("23423434","felix Hennerich", "12")
    GlobalScope.launch {
        //company.createCompany(User.User(uuid = "Thisistheuuid", email = "", password = "", name = "thisismyname", "", "", "",""),"Companyname")

        //commonLogger.log(fetcher.fetchErrorMessage(acc.createAccount("fehennerich@outloo.de", "12345678", "Felixx", "01.04.2005", "TeamThreads")))
    }

    /**
     *
     */

    //Decide the Screen that is shown
    when(currentScreen){
        is Screen.Register -> RegisterScreen().RegisterScreen(
            state = state,
            onEvent = viewModel::onEvent,
            localDataManager = appModule.localDataSource
        )

        else -> {}
    }
}


/**
 * Screens objects
 *
 * @object Loading -> Appears when loading
 */
sealed class Screen {
    data object Loading: Screen()
    data object Register: Screen()
}