package written_examination;

import java.util.Scanner;

public class xc2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int[][] gcd = new int[n][n];
        // 预处理gcd[i][j]，表示从a[i]到a[j]的子数组的gcd
        for (int i = 0; i < n; i++) {
            gcd[i][i] = a[i];
            for (int j = i + 1; j < n; j++) {
                gcd[i][j] = gcd(gcd[i][j - 1], a[j]);
            }
        }

        long[][] dp = new long[n + 1][m + 1];
        // 初始化dp数组
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= m; k++) {
                dp[i][k] = Long.MIN_VALUE;
            }
        }
        dp[0][0] = 0;

        // 动态规划计算dp数组
        for (int k = 1; k <= m; k++) {
            for (int i = k; i <= n; i++) {
                for (int j = k - 1; j < i; j++) {
                    if (dp[j][k - 1] != Long.MIN_VALUE) {
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + gcd[j][i - 1]);
                    }
                }
            }
        }

        System.out.println(dp[n][m]);
    }

    // 计算两个数的最大公约数
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
