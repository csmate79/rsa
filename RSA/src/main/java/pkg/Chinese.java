package pkg;

import java.math.BigInteger;
import java.security.Key;

public class Chinese {
    public static BigInteger ChiReminder(KeyPair key, BigInteger C) {

        //1. step
        BigInteger c1, c2;
        //c1 = C.modPow(key.d.mod(key.p.subtract(BigInteger.ONE)), key.p);
        c1 = fastPower.power(C , key.d.mod(key.p.subtract(BigInteger.ONE)), key.p);
        c2 = fastPower.power(C , key.d.mod(key.q.subtract(BigInteger.ONE)), key.q);
        //c2 = C.modPow(key.d.mod(key.q.subtract(BigInteger.ONE)), key.q);

        //2. step
        BigInteger M = key.p.multiply(key.q);
        BigInteger m1, m2;
        m1 = key.p;
        m2 = key.q;
        //3.step
        BigInteger M1 = M.divide(m1);
        BigInteger M2 = M.divide(m2);

        ExtEuclidean Eu = new ExtEuclidean();

        if (m1.compareTo(m2) == 1)
            Eu.EXTEuclidean(m1, m2);
        else
            Eu.EXTEuclidean(m2, m1);

        BigInteger y1, y2;

        if (Eu.X.mod(m1).equals(BigInteger.ONE)) {
            if(Eu.Y.compareTo(BigInteger.ZERO)==-1)
                y2 = m1.subtract(Eu.Y);
            else
                y2=Eu.Y;

            if(Eu.X.compareTo(BigInteger.ZERO)==-1)
                y1 = m1.subtract(Eu.X);
            else
                y1=Eu.X;
        }
        else
        {
            if(Eu.Y.compareTo(BigInteger.ZERO)==-1)
                y1 = m1.subtract(Eu.Y);
            else
                y1=Eu.Y;

            if(Eu.X.compareTo(BigInteger.ZERO)==-1)
                y2 = m1.subtract(Eu.X);
            else
                y2=Eu.X;
        }


        return (((c1.multiply(y1).multiply(M1)).add(c2.multiply(y2).multiply(M2))).mod(M));
    }
}
