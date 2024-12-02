package leetcode.lcsaf.sliding_window_and_double_pointer.fixed_length_sliding_window;

import java.util.Arrays;

public class LC1984 {
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
