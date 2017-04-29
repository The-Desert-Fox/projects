/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementrsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author S
 */
public class rsaclass {
    private BigInteger p;
    private BigInteger q;
    private BigInteger N; // N and e are public key
    private BigInteger mod;
    private BigInteger e;
    private BigInteger d; // N and d are private key
    private int bit = 1028;
    private Random r;
 
    public rsaclass()
    {
        r = new Random();
        p = BigInteger.probablePrime(bit, r);
        q = BigInteger.probablePrime(bit, r);
        N = p.multiply(q);
        // The mod((p-1)(q-1)) part, BigInteger.ONE is just the number 1
        mod = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bit / 2, r);
        
        // Finding a co-prime
        while (mod.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(mod) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(mod);
    }
    
    public byte[] encrypt(byte[] p){
        BigInteger plaintext = new BigInteger(p);
        return plaintext.modPow(e, N).toByteArray();
    }
    
    public byte[] decrypt(byte[] p){
        BigInteger cyphertext = new BigInteger(p);
        return cyphertext.modPow(d, N).toByteArray();
    }
}
