package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

import java.util.HashMap;
import java.util.Map;

public class 最多K个重复元素的最长子数组 {
    /**
     * 给你一个整数数组 nums 和一个整数 k 。
     *
     * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
     *
     * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
     *
     * 请你返回 nums 中 最长好 子数组的长度。
     *
     * 子数组 指的是一个数组中一段连续非空的元素序列。
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0, ans = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}
