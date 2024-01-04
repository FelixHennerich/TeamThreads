package utils

expect class CommonLogger() {

    /**
     * Log a message in Logcat
     */
    fun log(message: String)
}