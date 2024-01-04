package di

import data.DataStorageManager

expect class AppModule {
    val localDataSource: DataStorageManager
}