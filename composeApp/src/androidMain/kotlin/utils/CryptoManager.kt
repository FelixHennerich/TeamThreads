package utils

import android.util.Base64
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

actual class CryptoManager actual constructor() {

    actual fun encryptString(input: String, key: String): String {
        return input
    }
}