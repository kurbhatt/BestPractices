package org.kur.practice.algorithms;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
// Please import this from resources directory


/**
 * Created by Keyur on 14-09-2016.
 * This class have actual implementation of encryption and decryption of any sting using AES algorithm using encryption key.
 */
public class AES {

	public static void main(String[] args) {
		String encryptionKey = PropertyLoader.getSecurityKeyProperty().getProperty("ENCRYPTION_KEY");
		String password = PropertyLoader.getSecurityKeyProperty().getProperty("PASSWORD");
		String encryptedString = encrypt(password, encryptionKey);
		System.out.println("Original Password :: " + password);
		System.out.println("Encrypted Password :: " + encryptedString);
		String decryptedString = decrypt(encryptedString, encryptionKey);
		System.out.println("Decrypted Password :: " + decryptedString);
	}

	public static String encrypt(String input, String key) {
		byte[] crypted = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(input.getBytes());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new String(Base64.encodeBase64(crypted));
	}

	public static String decrypt(String input, String key) {
		byte[] output = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			output = cipher.doFinal(Base64.decodeBase64(input));
		} catch (IllegalBlockSizeException e) {
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new String(output);
	}
}
