package leetcode.lcsaf.滑动窗口.不定长滑动窗口.求最长最大;

import java.util.Arrays;

public class 最高频元素的频数 {
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
