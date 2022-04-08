import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyPair;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class RSA {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSA(){
        try{//Constructor to generate public and private key.
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
        } catch (Exception ignored) {}
    }

    private String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data){
        return Base64.getDecoder().decode(data);
    }

    public PublicKey getPKey(){
        return publicKey;
    }
    //Encryption method 
    public String encrypt(String message) throws Exception{
        byte[] messageToBytes = message.getBytes(); //Converts message to bytes for encryption
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }
    //Decryption method
    public String decrypt(String encryptedMessage) throws Exception{
        byte[] encryptedBytes = decode(encryptedMessage); 
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage,"UTF8");
    }

    public static void main(String[] args){
        RSA rsa = new RSA();
        Scanner s = new Scanner(System.in);

        System.out.println("Name:");
        String name = s.nextLine();
        
        System.out.println("Phone Number:");
        String phone = s.nextLine();
        
        System.out.println("Email Address:");
        String mail = s.nextLine();
        
        System.out.println("Card Number:");
        String card = s.nextLine();

        try{
            String eName = rsa.encrypt(name);
            String ePhone = rsa.encrypt(phone);
            String eMail = rsa.encrypt(mail);
            String eCard = rsa.encrypt(card);

            //String dName = rsa.decrypt("");

            System.err.println("Payment info: " + eName + ",\n" + ePhone + ",\n" + eMail + ",\n" + eCard);
            //System.err.println("Decrypted: \n" + decryptedMessage);

        }catch (Exception ignored){}

    }
} 