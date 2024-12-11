package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_number_of_subarrays.longer_more_legal;

import java.util.HashMap;
import java.util.Map;

public class LC2537 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
     * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
     * 子数组 是原数组中一段连续 非空 的元素序列。
     * 1 <= nums.length <= 10e5
     * 1 <= nums[i], k <= 10e9
     */
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            cnt += map.get(nums[right]) - 1;
            while (cnt >= k) {
                ans += n - right;
                map.put(nums[left], map.get(nums[left]) - 1);
                cnt -= map.get(nums[left]);
                left++;
            }
        }
        return ans;
    }
}
