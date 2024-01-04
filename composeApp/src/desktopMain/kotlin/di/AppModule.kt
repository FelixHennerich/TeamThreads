package di

import data.DataStorageManager
import java.util.prefs.Preferences

actual class AppModule {
    actual val localDataSource: DataStorageManager by lazy {
        DataStorageManager(
            Preferences.userRoot().node("TeamThreads")
        )
    }
}
