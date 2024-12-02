package written_examination.bytedance;

import java.math.BigInteger;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] coins = new long[n];
        long[] params = new long[m];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            params[i] = scanner.nextInt();
        }
        BigInteger result = calculateReturn(coins, params);
        System.out.println(result);
    }
    static BigInteger calculateReturn(long[] coins, long[] params) {
        BigInteger result = new BigInteger(String.valueOf(0));
        for (long coin : coins) {
            BigInteger term = new BigInteger(String.valueOf(1));
            for (long p : params) {
//                term *= (p - coin);
                term.multiply(new BigInteger(String.valueOf(p - coin)));
            }
            result.add(term);
        }
        return result;
    }
}
