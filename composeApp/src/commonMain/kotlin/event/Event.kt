package event

import data.local.DataStorageManager
import kotlinx.coroutines.flow.MutableStateFlow

interface Event {

    fun onEvent(localDataSource: DataStorageManager, _state: MutableStateFlow<ThreadState>)

}