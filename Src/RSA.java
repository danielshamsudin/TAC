package Src;// RSA-1024 implementation by Daniel

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA{
  private final static SecureRandom random = new SecureRandom();

  private BigInteger privateKey;
  private BigInteger publicKey;
  private BigInteger modulus;
  private String pubKey;
  private String privKey;

  public RSA(int N){
    BigInteger p = BigInteger.probablePrime(N/2, random);
    BigInteger q = BigInteger.probablePrime(N/2, random);
    BigInteger phi = (p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1"))));

    modulus = p.multiply(q); // n = pq
    publicKey = new BigInteger("65537"); // e
    privateKey = publicKey.modInverse(phi); // d
    pubKey = publicKey.toString(16);
    privKey = privateKey.toString(16);
  }

  public BigInteger encrypt(BigInteger message){
    return message.modPow(privateKey, modulus);
  }

  public BigInteger decrypt(BigInteger encrypted){
    return encrypted.modPow(publicKey, modulus);
  }

  SecureRandom getRandom(){
    return random;
  }
  
  public String toString(){
    String s = "";
    s += "public = " + new String(publicKey.toString(16)) + "\n";
    s += "public decl = " + pubKey + "\n";
    s += "private = " + new String(privateKey.toString(16)) + "\n";
    s += "priv decl = " + privKey + "\n";
    s += "modulus = " + modulus;
    return s;
  }

  public String getPublicKey(){
    return pubKey;
  }

  public String getPrivateKey(){
    return privateKey.toString(16);
  }

  public String getModulus() { return modulus.toString(16); };

}