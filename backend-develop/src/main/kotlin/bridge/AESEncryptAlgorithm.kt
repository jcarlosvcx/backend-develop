package bridge

import oracle.net.aso.c
import java.security.Key
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class AESEncryptAlgorithm: IEncryptAlgorithm {
    override fun encrypt(message: String, password: String): String {
        val key: Key = SecretKeySpec(password.toByteArray(),"AES")
        val c = Cipher.getInstance("AES")
        c.init(Cipher.ENCRYPT_MODE, key)
        return  Base64.getEncoder().encodeToString(c.doFinal(message.toByteArray()))
    }
}
