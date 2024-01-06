package data.local

import java.util.prefs.Preferences

actual class DataStorageManager(
    private val preferences: Preferences = Preferences.userRoot().node("TeamThreads")
) {

    /**
     * Save String in the local device storage
     *
     * @param key -> What should be saved?
     * @param value -> This value will be assigned
     * @sample key = "email"
     * @sample value = "test@test.de"
     */
    actual fun saveString(key: String, value: String) {
        preferences.put(key, value)
    }

    /**
     * Read String from the local device storage
     *
     * @param key -> What should be read?
     * @sample key = "email"
     * @return value -> the assigned value to the key
     * @sample value = "test@test.de"
     */
    actual fun readString(key: String): String? {
        return preferences.get(key, null)
    }

    /**
     * Save Int in the local device storage
     *
     * @param key -> What should be saved?
     * @param value -> This value will be assigned
     * @sample key = "age"
     * @sample value = "23"
     */
    actual fun saveInt(key: String, value: Long) {
        preferences.putLong(key, value)
    }

    /**
     * Read Int from the local device storage
     *
     * @param key -> What should be read?
     * @sample key = "age"
     * @return value -> the assigned value to the key
     * @sample value = "23"
     */
    actual fun readInt(key: String, defaultValue: Int): Int {
        return preferences.getLong(key, defaultValue.toLong()).toInt()
    }

    /**
     * Delete Value from local data storage
     *
     * @param key -> What should be deleted?
     * @sample key = "email"
     */
    actual fun deleteEntry(key: String) {
        preferences.remove(key)
    }
}