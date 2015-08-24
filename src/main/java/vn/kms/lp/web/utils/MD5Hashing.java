package vn.kms.lp.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5Hashing {
private static final Logger log = LoggerFactory.getLogger(MD5Hashing.class);
    public static String getHashedPassword(String password) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteData = md.digest();
            
            // convert the byte to hex format
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1){
                    hexString.append('0');
                }                    
                hexString.append(hex);
            }
            System.out.println("Digest(in hex format):: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(),e);
        }
        return hexString.toString();
    }
    
    public static void main(String[] args) {
        MD5Hashing.getHashedPassword("123");
    }
}
