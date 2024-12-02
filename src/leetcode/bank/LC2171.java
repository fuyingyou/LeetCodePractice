package leetcode.bank;

import java.util.Arrays;

public class LC2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int n = beans.length;
        long[] pre = new long[n];
        long[] end = new long[n];
        for (int i = 0; i < n - 1; i++) {
            pre[i + 1] = pre[i] + beans[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            end[i] = end[i + 1] + (long) (beans[i + 1] - beans[i]) * (n - 1 - i);
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, pre[i] + end[i]);
        }
        return ans;
    }
}
