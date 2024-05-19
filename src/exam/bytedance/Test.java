package exam.bytedance;

import java.util.Scanner;

public class Test {
    private static final long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        long result = countChorusPlans(n, m, k);
        System.out.println(result);
    }
    static long combination(int n, int k) {
        if (k > n) return 0;
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < k; i++) {
            numerator = (numerator * (n - i)) % MOD;
            denominator = (denominator * (i + 1)) % MOD;
        }
        return (numerator * pow(denominator, MOD - 2, MOD)) % MOD;
    }

    // 快速幂取模
    static long pow(long x, long y, long MOD) {
        long result = 1;
        x %= MOD;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }
            y /= 2;
            x = (x * x) % MOD;
        }
        return result;
    }

    // 计算合唱队方案数
    static long countChorusPlans(int n, int m, int k) {
        long totalPlans = 0;
        for (int x = 3; x <= Math.min(k, n); x++) {
            int y = k - x;
            if (y >= 2 && y <= m) {
                long plansWithXBoys = combination(n, x);
                long plansWithYGirls = combination(m, y);
                totalPlans = (totalPlans + (plansWithXBoys * plansWithYGirls) % MOD) % MOD;
            }
        }
        return totalPlans;
    }
}
