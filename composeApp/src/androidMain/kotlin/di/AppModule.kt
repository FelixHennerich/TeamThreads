package di

import android.content.Context
import data.DataStorageManager

actual class AppModule(
    private val context: Context
) {
    actual val localDataSource: DataStorageManager by lazy {
        DataStorageManager(
            context
        )
    }

}