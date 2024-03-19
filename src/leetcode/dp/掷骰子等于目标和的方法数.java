package leetcode.dp;

public class 掷骰子等于目标和的方法数 {
    private final static int MOD = (int) (1e9 + 7);
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || n * k < target) {
            return 0;
        }
        long[] f = new long[target - n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int mx = Math.min(i * (k - 1), target - n);
            for (int j = 1; j <= mx; j++) {
                f[j] += f[j - 1];
            }
            for (int j = mx; j >= k; j--) {
                f[j] = (f[j] - f[j - k]) % MOD;
            }
        }
        return (int) f[target - n];
    }
    private int dfs(int n, int k, int target) {
        if (n < 1) {
            return target == 0 ? 1 : 0;
        }
        if (n * k < target) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum = (sum + dfs(n - 1, k, target - i)) % MOD;
        }
        return sum;
    }
}
