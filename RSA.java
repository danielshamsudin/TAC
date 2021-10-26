// RSA-1024 implementation by Daniel

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA{
  private final static SecureRandom random = new SecureRandom();

  private BigInteger privateKey;
  private BigInteger publicKey;
  private BigInteger modulus;

  RSA(int N){
    BigInteger p = BigInteger.probablePrime(N/2, random);
    BigInteger q = BigInteger.probablePrime(N/2, random);
    BigInteger phi = (p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1"))));

    modulus = p.multiply(q); // n = pq
    publicKey = new BigInteger("65537"); // e
    privateKey = publicKey.modInverse(phi); // d
  }

  BigInteger encrypt(BigInteger message){
    return message.modPow(publicKey, modulus);
  }

  BigInteger decrypt(BigInteger encrypted){
    return encrypted.modPow(privateKey, modulus);
  }

  SecureRandom getRandom(){
    return random;
  }
  
  public String toString(){
    String s = "";
    s += "public = " + new String(publicKey.toString(16)) + "\n";
    s += "private = " + new String(privateKey.toString(16)) + "\n";
    s += "modulus = " + modulus;
    return s;
  }

}