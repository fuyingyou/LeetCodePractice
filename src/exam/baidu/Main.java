package exam.baidu;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        BigInteger result1 = new BigInteger(String.valueOf(1));
        BigInteger base1 = BigInteger.valueOf(a);
        int power1 = b;
        while (power1 > 0) {
            int x = power1 & 1;
            if (x == 1) {
                result1 = result1.multiply(base1);
            }
            base1 = base1.multiply(base1);
            power1 = power1 >>> 1;
        }
        System.out.println(result1);
        BigInteger result2 = new BigInteger(String.valueOf(1));
        BigInteger base2 = BigInteger.valueOf(b);
        int power2 = a;
        while (power2 > 0) {
            int x = power2 & 1;
            if (x == 1) {
                result2 = result2.multiply(base2);
            }
            base2 = base2.multiply(base2);
            power2 = power2 >>> 1;
        }
        System.out.println(base1);
        System.out.println(base2);
        int compareTo = base1.compareTo(base2);
        if (compareTo < 0) {
            System.out.println('<');
        } else {
            System.out.println('>');
        }
    }
}
