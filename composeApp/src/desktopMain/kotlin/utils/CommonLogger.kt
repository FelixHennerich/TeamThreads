package utils

actual class CommonLogger actual constructor() {
    /**
     * Log a message in Logcat
     */
    actual fun log(message: String) {
        println(message)
    }

}