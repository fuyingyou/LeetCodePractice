package leetcode.lcsaf.滑动窗口.定长滑动窗口;

import java.util.Arrays;

public class 学生分数的最小差值 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n + 1 - k; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}
