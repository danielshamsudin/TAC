package Src;/* You can also make use of the crypto libraries to
perform the SHA-256 hashing. Another good resource is the 
AMCL(Cryptographic Library) library: https://github.com/miracl/amcl/tree/master/version3/java
*/

import Stuff.Sign;
import Stuff.SignAndVerify;
import Stuff.Verify;

import java.io.File;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) throws Exception {
    Sign s = new Sign();
    SignAndVerify ss = new SignAndVerify();
    Verify sss = new Verify();
    ss.display();
//    File file = new File("Src/naive.txt"); //check SHA-256 checksum for file
//    int N = 1024;
//    RSA key = new RSA(N); // generate new RSA key pair, check RSA.java for more details
//    SHA256 shadigest = new SHA256(file); // retrieve SHA-256 checksum from file, check SHA256.java for more details
//
//    byte[] bytes = shadigest.returnHex().getBytes();
//    BigInteger message = new BigInteger(bytes);
//    BigInteger en = key.encrypt(message);
//    BigInteger de = key.decrypt(en);
//    System.out.println("message: " + message);
//    System.out.println("encrypted: " + new String(en.toByteArray()));
//    System.out.println("decrypted: " + de);
//    System.out.println(key.toString());
//    shadigest.printHex();
  }
}