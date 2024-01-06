package di

import data.local.DataStorageManager

expect class AppModule {
    val localDataSource: DataStorageManager
}