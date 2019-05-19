package pkg;

import java.math.BigInteger;

public class ExtEuclidean {
    BigInteger Y,X,yn;

    public void EXTEuclidean(BigInteger a, BigInteger b) {
        BigInteger[] firstrow = new BigInteger[400];
        BigInteger[] secondrow = new BigInteger[400];
        BigInteger[] thirdrow = new BigInteger[400];
        BigInteger[] fourthrow = new BigInteger[400];

        firstrow[0] = a;
        firstrow[1] = b;
        secondrow[0] = BigInteger.valueOf(0);
        secondrow[1] = a.divide(b);
        thirdrow[0] = BigInteger.valueOf(1);
        thirdrow[1] = BigInteger.valueOf(0);
        fourthrow[0] = BigInteger.valueOf(0);
        fourthrow[1] = BigInteger.valueOf(1);

        int i = 2;
        while (!firstrow[i - 1].equals(BigInteger.valueOf(0))) {
            firstrow[i] = firstrow[i - 2].mod(firstrow[i - 1]);
            if(firstrow[i].equals(BigInteger.valueOf(0)))
                break;
            secondrow[i] = firstrow[i - 1].divide(firstrow[i]);
            thirdrow[i] = (thirdrow[i - 1].multiply(secondrow[i - 1])).add(thirdrow[i - 2]);
            fourthrow[i] = (fourthrow[i - 1].multiply(secondrow[i - 1])).add(fourthrow[i - 2]);
            i++;
        }
        yn = fourthrow[i-1];
        X = (BigInteger.valueOf(-1)).pow(i - 1).multiply(thirdrow[i - 1]);
        Y = (BigInteger.valueOf(-1)).pow(i).multiply(fourthrow[i - 1]);
    }
}