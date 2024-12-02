package leetcode.lcsaf.sliding_window_and_double_pointer;

import java.util.HashMap;

public class LC2461 {
    /**
     * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
     *
     * 子数组的长度是 k，且
     * 子数组中的所有元素 各不相同 。
     * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
     *
     * 子数组 是数组中一段连续非空的元素序列。
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            cnt += nums[i];
        }

        if (map.size() == k) {
            ans = Math.max(ans, cnt);
        }
        int right = k;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.get(nums[left]) == 1) {
                map.remove(nums[left]);
            } else {
                map.put(nums[left], map.get(nums[left]) - 1);
            }
            cnt += nums[right];
            cnt -= nums[left];
            if (map.size() >= k) {
                ans = Math.max(ans, cnt);
            }
            left++;
            right++;
        }

        return ans;
    }


}
