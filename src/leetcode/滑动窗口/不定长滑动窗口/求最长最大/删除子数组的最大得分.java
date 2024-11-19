package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

import java.util.HashMap;
import java.util.Map;

public class 删除子数组的最大得分 {
    /**
     * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
     *
     * 返回 只删除一个 子数组可获得的 最大得分 。
     *
     * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
     */
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0, sum = 0, ans = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > 1) {
                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }
            ans = Math.max(ans, sum);
            right++;
        }

        return ans;
    }
}
