/* You can also make use of the crypto libraries to 
perform the SHA-256 hashing. Another good resource is the 
AMCL(Cryptographic Library) library: https://github.com/miracl/amcl/tree/master/version3/java
*/

import java.math.BigInteger;
import java.security.*;  //provides methods for signing the data
import java.io.IOException;
import java.io.*;

class Main {
  // public static void main(String[] args) {
  //   System.out.println("Hi JX, Felix, NJ, Daniel! Here will be our shared code platform");
  // }
  // NJ was here xDDDDDDDDDDDDDD
  
  public static void main(String[] args) throws NoSuchAlgorithmException,IOException{
    File file = new File("naive.txt"); //check SHA-256 checksum for file
    int N = 1024;
    RSA key = new RSA(N); // generate new RSA key pair, check RSA.java for more details
    SHA256 shadigest = new SHA256(file); // retrieve SHA-256 checksum from file, check SHA256.java for more details

    byte[] bytes = shadigest.returnHex().getBytes();
    BigInteger message = new BigInteger(bytes);
    BigInteger en = key.encrypt(message);
    BigInteger de = key.decrypt(en);
    System.out.println("message: " + new String(message.toByteArray()));
    System.out.println("encrypted: " + new String(en.toByteArray()));
    System.out.println("decrypted: " + new String(de.toByteArray()));
    System.out.println(key.toString());
    shadigest.printHex();
  }
}