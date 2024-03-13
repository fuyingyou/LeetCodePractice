package leetcode.dp.记忆化搜索和递推;

public class 统计构造好字符串的方案数 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = (int) (1e9 + 7);
        int[] f = new int[high + 1];
        f[0] = 1;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                f[i] = (f[i] + f[i - zero]) % mod;
            }
            if (i >= one) {
                f[i] = (f[i] + f[i - one]) % mod;
            }
            if (i >= low) {
                ans = (ans + f[i]) % mod;
            }
        }
        return ans;
    }
}
