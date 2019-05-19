package pkg;

import java.math.BigInteger;
import java.util.Random;

public class KeyPair {

        BigInteger e,d,n,p,q,phi_n;

        public void PrimePair(){

            p = KeyGeneration();
            q = KeyGeneration();

            n = p.multiply(q);
           phi_n=Euler.Euler(p,q);



            for(BigInteger i = BigInteger.valueOf(2); i.compareTo(phi_n) < 0; i = i.add(BigInteger.valueOf(1))) {
                if(Euclidean.Euclidean(phi_n,i).equals(BigInteger.valueOf(1))) {
                    e = i;
                    break;
                }
            }

            /*BigInteger k =BigInteger.ONE;
            while (!((BigInteger.ONE.add(k.multiply(phi_n)).mod(e)).equals(BigInteger.ZERO)) ){
                d = BigInteger.ONE.add(k.multiply(phi_n)).divide(e);
                //System.out.println(d);
                k=k.add(BigInteger.ONE);
            }*/

            ExtEuclidean eu = new ExtEuclidean();
            eu.EXTEuclidean(phi_n,e);
            if((eu.Y).compareTo(BigInteger.valueOf(0))<0)
                d=phi_n.add(eu.Y);
            else
                d=eu.Y;

        }


    public BigInteger KeyGeneration(){
         int SizeOfBit = 500;
         Random rand = new Random();

        for(;;) {
            BigInteger key = BigInteger.probablePrime(SizeOfBit, rand);
            if(isPrime(key, 20)) {
                return key;
            }
        }
        }

    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");

    public static boolean isPrime(BigInteger n, int k) {
        if (n.compareTo(ONE) == 0)
            return false;
        if (n.compareTo(THREE) < 0)
            return true;
        int s = 0;
        BigInteger d = n.subtract(ONE);
        while (d.mod(TWO).equals(ZERO)) {
            s++;
            d = d.divide(TWO);
        }
        for (int i = 0; i < k; i++) {
            BigInteger a = uniformRandom(TWO, n.subtract(ONE));
            BigInteger x = fastPower.power(a , d , n);
            if (x.equals(ONE) || x.equals(n.subtract(ONE)))
                continue;
            int r = 0;
            for (; r < s; r++) {
                x = fastPower.power(x, TWO, n);
                if (x.equals(ONE))
                    return false;
                if (x.equals(n.subtract(ONE)))
                    break;
            }
            if (r == s) // Semelyik lépés se lesz n-1.
                return false;
        }
        return true;
    }

    private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
        Random rnd = new Random();
        BigInteger res;
        do {
            res = new BigInteger(top.bitLength(), rnd);
        } while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
        return res;
    }

}

    /*public boolean isPrime(BigInteger number) {
        for(BigInteger i = BigInteger.valueOf(2); i.compareTo(number.sqrt()) <= 0; i = i.add(BigInteger.ONE)) {
            if (number.mod(i).compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
        }
        return true;
    }*/

