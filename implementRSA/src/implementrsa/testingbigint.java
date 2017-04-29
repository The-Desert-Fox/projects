/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementrsa;

import java.math.BigInteger;

/**
 *
 * @author S
 */
public class testingbigint {
    public static void main(String[] args) {
        //Focus modPow and mod inverse
        BigInteger sum = BigInteger.valueOf(0);
        for(int i = 0; i < 5000; i++) { 
            sum = sum.add(BigInteger.valueOf(i));
        }
        //System.out.println(sum);
        BigInteger exp = new BigInteger("9");
        BigInteger num1 = BigInteger.valueOf(2);
        BigInteger num2 = BigInteger.valueOf(5);
        //2^2 mod 5
        // this.modPow(Power, mod)
        BigInteger num3 = num1.modPow(num1, num2);
        System.out.println(num3);
        
        BigInteger num4 = num1.modInverse(exp);
        System.out.println(num4);
        // this(^-1).modInverse(mod)
        
        BigInteger num5 = new BigInteger("11");
        System.out.println(num5.nextProbablePrime());
        System.out.println(BigInteger.ONE);
        //BigInteger p = BigInteger.probablePrime(0, random);
        
    }
}
