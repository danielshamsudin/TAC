// SHA-256 Implementation by NJ

import java.math.BigInteger;
import java.security.*; 
import java.io.IOException;
import java.io.*;

public class SHA256 {
    private byte[] digest;
    private String hex;

    SHA256(File digestfile) throws IOException, NoSuchAlgorithmException
    {
        FileInputStream read = new FileInputStream(digestfile);
        MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");
        BufferedInputStream buff = new BufferedInputStream(read);
        DigestInputStream dig = new DigestInputStream(buff, msgDigest);

        while(dig.read() != -1)
        {
            ; // Intentionally left blank
        }

        dig.close();
        digest = msgDigest.digest();
        hex = String.format("%064x", new BigInteger(1, digest));
    }

    String returnHex() throws IOException
    {
        return hex; //returns SHA-256 hash in hexadecimal string
    }
    
    void printHex() 
    {
        System.out.println("SHA-256 Checksum: " + hex); //prints SHA-256 hash in hexadecimal string
    }
}