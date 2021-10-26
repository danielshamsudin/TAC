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

    modulus = p.multiply(q);
    publicKey = new BigInteger("65537");
    privateKey = publicKey.modInverse(phi);
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
    s += "public = " + publicKey + "\n";
    s += "private = " + privateKey + "\n";
    s += "modulus = " + modulus;
    return s;
  }

}