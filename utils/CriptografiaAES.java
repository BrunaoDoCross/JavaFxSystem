package utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaAES {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "A74NDJ4MZ0A74LD6"; // Chave de criptografia (16 caracteres)

    public static String criptografar(String texto) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textoCriptografado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(textoCriptografado);
        } catch (Exception e) {
            System.out.println("Erro ao criptografar: " + e.getMessage());
        }
        return null;
    }

    public static String descriptografar(String textoCriptografado) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textoBytes = Base64.getDecoder().decode(textoCriptografado);
            byte[] textoDescriptografado = cipher.doFinal(textoBytes);
            return new String(textoDescriptografado, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Erro ao descriptografar: " + e.getMessage());
        }
        return null;
    }
}
