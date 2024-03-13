package leetcode.dp.背包;

import java.util.Arrays;

public class 目标和 {
    /**
     * sum1 + sum2 = sum
     * sum1 - sum2 = t
     * sum1 = (sum + t) / 2
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        target += Arrays.stream(nums).sum();
        if (target < 0 || target % 2 == 1) {
            return 0;
        }
        target /= 2;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int x : nums) {
            for (int c = target; c >= x; c--) {
                f[c] += f[c - x];
            }
        }
        return f[target];
    }
}
