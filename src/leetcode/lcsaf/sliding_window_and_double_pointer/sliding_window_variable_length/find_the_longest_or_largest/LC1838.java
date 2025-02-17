package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_longest_or_largest;

import java.util.Arrays;

public class LC1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1;
        long cnt = 0;
        for (int left = 0, right = 1; right < n; right++) {
            cnt += (long)(right - left) * (nums[right] - nums[right - 1]);
            while (cnt > k) {
                cnt -= nums[right] - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
