package event

import data.local.DataStorageManager
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class ThreadViewModel(
    private val localDataStorageManager: DataStorageManager
): ViewModel() {
    private val _state = MutableStateFlow(ThreadState())

    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), ThreadState())


    /**
     * Called on every event
     *
     * @param event -> Eventtype
     */
    fun onEvent(event: ThreadEvent){
        when(event){
            is ThreadEvent.TestEvent -> {
                _state.update { it.copy(
                    testvalue = "Edited"
                ) }
            }
            is ThreadEvent.RegisterErrorMessageUpdate -> {
                _state.update { it.copy(
                    RegisterErrorMessage = event.message
                ) }
            }
        }
    }
}