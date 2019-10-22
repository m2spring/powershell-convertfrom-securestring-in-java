package org.example;

import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionTest{

    SecretKeySpec key;
    IvParameterSpec ivSpec;
    Cipher cipher;

    @Before
    public void init() throws Exception{
        int[] ints = {202,144,73,88,228,1,7,104,95,212,137,87,125,201,80,75,53,18,39,108,60,218,212,151,239,241,34,117,106,184,212,179};
        byte[] bytes = new byte[ints.length];
        for (int i=0; i<ints.length; i++){
            bytes[i] = (byte)ints[i];
        }
        key = new SecretKeySpec(bytes, "AES");

        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        ivSpec = new IvParameterSpec(iv);

        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    @Test
    public void testIt() throws Exception{
        String secret = "banana";

        System.out.println("secret   : "+secret);

        byte[] encrypted = encrypt(secret);
        System.out.println("encrypted: "+Base64.getEncoder().encodeToString(encrypted));

        String decrypted = decrypt(encrypted);
        System.out.println("decrypted: "+decrypted);
    }

    byte[] encrypt(String secret) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        return cipher.doFinal(secret.getBytes());
    }

    String decrypt(byte[] encrypted) throws Exception{
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        return new String(cipher.doFinal(encrypted));
    }
}
