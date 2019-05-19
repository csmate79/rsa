package pkg;

import java.math.BigInteger;

public class Decrypt {
    public static String decodeEncrypted(BigInteger[] c,BigInteger d, BigInteger p, BigInteger q) {
        ExtEuclidean ex = new ExtEuclidean();
        long[] temp = new long[c.length];

        StringBuilder demes = new StringBuilder();

        BigInteger cp, cq;
        ex.EXTEuclidean(p , q);

        for(int i = 0; i < c.length; i++){
            cp = fastPower.power(c[i] , d.mod(p.subtract(BigInteger.ONE)),q);
            cq = fastPower.power(c[i] , d.mod(q.subtract(BigInteger.ONE)),p);

            temp[i] = (((p.multiply(cp).multiply(ex.X)).add(p.multiply(cq).multiply(ex.Y))).mod(p.multiply(q))).longValue();
        }



        for (int i = 0; i < c.length; i++){
            demes.append((char) temp[i]);
        }
        return demes.toString();
    }

}
    /*public static String Decryption(KeyPair key, BigInteger[] crypted){

        long[] temp = new long[crypted.length];
        StringBuilder message = new StringBuilder();


        for (int i = 0; i < crypted.length; i++) {
            temp[i]=fastPower.power(crypted[i], key.d , key.n).longValue();
        }

        for (int i = 0; i < temp.length; i++) {
            message.append((char) temp[i]);
        }

        *//*for (int i = 0; i < crypted.length; i++) {
            temp[i]=Chinese.ChiReminder(key,crypted[i]).longValue();
        }

        for (int i = 0; i < message.length(); i++) {
            temp[i]=fastPower.power(crypted[i],key.d ,key.n).longValue();
        }

        for (int i = 0; i < temp.length; i++) {
            message.append((char) temp[i]);
        }*//*

        return message.toString();
}
}*/
