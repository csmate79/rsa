package pkg;

import java.math.BigInteger;

public class Euclidean {

    public static BigInteger Euclidean(BigInteger a, BigInteger b){

        BigInteger tabla[]=new BigInteger[200];

        tabla[0]=a;
        tabla[1]=b;

        int i=2;
        while(true)
        {
            tabla[i]=tabla[i-2].mod(tabla[i-1]);
            if(tabla[i].equals(BigInteger.valueOf(0)))
                break;
            i++;
        }


        return tabla[i-1];
    }
}
