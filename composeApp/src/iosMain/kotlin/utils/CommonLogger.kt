package utils

actual class CommonLogger {

    actual fun log(message: String){
        println(message)
    }
}