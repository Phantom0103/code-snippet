package com.wenxia.snippet.aes;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

/**
 * @Author Zhouw
 * @Date 2023/3/27
 */
public class AesEncryptUtils {

    private AesEncryptUtils() {

    }

    private static final String ENCRYPT_KEY = "Hello World!";

    private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";

    /**
     * 加密
     */
    public static String encrypt(String content, String secret) throws Exception {
        byte[] encryptKey = DigestUtils.md5Digest(secret.getBytes(StandardCharsets.UTF_8));
        IvParameterSpec iv = ivParams();
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey, "AES"), iv);
        byte[] b = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        byte[] ivb = iv.getIV();
        // 将加密向量一起追加到密文中，用来解密
        byte[] rb = mergeBytes(b, ivb);

        return Base64Utils.encodeToUrlSafeString(rb);
    }

    /**
     * 加密，用默认的encrypt_key
     */
    public static String encrypt(String content) throws Exception {
        return encrypt(content, ENCRYPT_KEY);
    }

    /**
     * 解密
     */
    public static String decrypt(String encryptStr, String secret) throws Exception {
        byte[] encryptBytes = Base64Utils.decodeFromUrlSafeString(encryptStr);
        // 分离密文和加密向量
        byte[] ivb = new byte[16];
        byte[] b = new byte[encryptBytes.length - 16];
        System.arraycopy(encryptBytes, 0, b, 0, b.length);
        System.arraycopy(encryptBytes, b.length, ivb, 0, ivb.length);
        byte[] decryptKey = DigestUtils.md5Digest(secret.getBytes(StandardCharsets.UTF_8));
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey, "AES"), new IvParameterSpec(ivb));
        byte[] decryptBytes = cipher.doFinal(b);

        return new String(decryptBytes, StandardCharsets.UTF_8);
    }

    /**
     * 解密，用默认的encrypt_key
     */
    public static String decrypt(String encryptStr) throws Exception {
        return decrypt(encryptStr, ENCRYPT_KEY);
    }

    private static IvParameterSpec ivParams() {
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[16];
        random.nextBytes(ivBytes);

        return new IvParameterSpec(ivBytes);
    }

    private static byte[] mergeBytes(byte[] bytes1, byte[] bytes2) {
        byte[] result = new byte[bytes1.length + bytes2.length];
        System.arraycopy(bytes1, 0, result, 0, bytes1.length);
        System.arraycopy(bytes2, 0, result, bytes1.length, bytes2.length);

        return result;
    }
}
