package leetcode.lcsaf.dp;

public class 统计放置房子的方式数 {
    private final static int MOD = (int) (1e9 + 7);
    public int countHousePlacements(int n) {
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        f[n] %= MOD;
        return (int) (f[n] * f[n] % MOD);
    }

    private long dfs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        return dfs(n - 1) + dfs(n - 2);
    }
}
