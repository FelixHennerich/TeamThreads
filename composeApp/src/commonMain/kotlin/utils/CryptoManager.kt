package utils

expect class CryptoManager() {
    fun encryptString(input: String, key: String): String
}