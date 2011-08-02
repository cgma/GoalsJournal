package jmydays.util;

import java.io.UnsupportedEncodingException;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.GeneralSecurityException;


public class CryptoUtils implements jmydays.JMyDaysConstants {
	public static final String AES = "AES";
	
	private static String currentPassword = EMPTY_PASS_STRING;
	
	public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if( text == null){
			return null;
		}
		
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		return byteArrayToHexString( md.digest() ); //pass sha1hash
	}
	
    public static String encrypt(final String value) {
    	try{
    		return encrypt(currentPassword, value);
    	}catch(Exception e){
			System.err.println("Encrypted value: " + value + " -> " + e.getMessage());
			return value;
		}
    }
    
    /**
     * Encrypt a value with the given password.
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static String encrypt(final String password, final String value) throws GeneralSecurityException, IOException {

        SecretKeySpec sks = getSecretKeySpec(password);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return byteArrayToHexString(encrypted);
    }

    public static String decrypt(final String value) {
    	try{
    		return decrypt(currentPassword, value);
    	}catch(Exception e){
			System.err.println("Returning encrypted value: " + value + " -> " + e.getMessage());
			return value;
		}
    }
    
    /**
     * Decrypt a value with the given password.
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static String decrypt(final String password, final String value) throws GeneralSecurityException, IOException {
        SecretKeySpec sks = getSecretKeySpec(password);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, sks);
        byte[] decrypted = cipher.doFinal( hexStringToByteArray(value) );
        return new String(decrypted);
    }

    private static SecretKeySpec getSecretKeySpec(final String password) throws NoSuchAlgorithmException, IOException {
        byte[] key = hexStringToByteArray(password);
        SecretKeySpec sks = new SecretKeySpec(key, AES);
        return sks;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    private static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }


	public static void setCurrentPassword(String password) {
		if( password != null && password.trim().length() > 0 ){
			try{
				CryptoUtils.currentPassword = SHA1(password).substring(8); // AES just needs 32 CHARS, not 40 //
			}catch(Exception e){
				System.err.println("Exception" + e.getMessage());
				CryptoUtils.currentPassword = (java.util.ResourceBundle.getBundle("config")).getString("defaultPass");
			}
		}
	}

	public static String getCurrentPassword() {
		return CryptoUtils.currentPassword;
	}

	public static final String CIPHERED_MATCH_REGEX = "[A-Z0-9]+";
	
	public static boolean isStrCiphered(final String testStr){
		if( !testStr.matches(CIPHERED_MATCH_REGEX) ){
			return false;
		}
		
		return true;
	}

}