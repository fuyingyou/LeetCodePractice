package leetcode.dp;

import java.util.Arrays;

public class K次串联后最大子数组之和 {
    private final static int MOD = (int) (1e9 + 7);
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int len = Math.min(2, k) * n;
        int mx = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            cur = Math.max(cur + arr[i % n], arr[i % n]);
            mx = Math.max(mx, cur);
        }
        int sum = Arrays.stream(arr).sum();
        if (k >= 2 && sum > 0) {
            mx = (int)((mx + (long)sum * (k - 2)) % MOD);
        }
        return mx;
    }
}
