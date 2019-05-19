package pkg;

import java.math.BigInteger;

public class Euler {

    public static BigInteger Euler(java.math.BigInteger p, java.math.BigInteger q){

        BigInteger Phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        return Phi_n;
    }
}
