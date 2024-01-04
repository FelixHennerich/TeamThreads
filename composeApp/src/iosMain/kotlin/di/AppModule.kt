package di

import data.DataStorageManager



actual class AppModule {

    /**
     * LocalDataSource -> LocalDataSystem to store and read information
     */
    actual val localDataSource: DataStorageManager by lazy {
        DataStorageManager()
    }
}