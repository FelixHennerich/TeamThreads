package event

import data.DataStorageManager
import kotlinx.coroutines.flow.MutableStateFlow

interface Event {

    fun onEvent(localDataSource: DataStorageManager, _state: MutableStateFlow<ThreadState>)

}