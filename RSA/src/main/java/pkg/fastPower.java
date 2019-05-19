package pkg;

import java.math.BigInteger;

public class fastPower {

    static BigInteger power(BigInteger x, BigInteger y, BigInteger n) {

        BigInteger res = BigInteger.ONE;

        x = x.mod(n);

        while (y.compareTo(BigInteger.ZERO) > 0) {
            if (y.and(BigInteger.ONE).equals(BigInteger.ONE))
                res = res.multiply(x).mod(n);

            y = y.shiftRight(1);
            x = x.multiply(x).mod(n);
        }

        return res;
    }
}
