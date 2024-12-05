package leetcode.lcsaf.sliding_window_and_double_pointer.variable_length_sliding_window.find_the_number_of_subarrays.shorter_more_legal;

public class LC2302 {
    /**
     * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
     * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
     * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
     * 子数组 是数组中的一个连续元素序列。
     * 1 <= nums.length <= 10e5
     * 1 <= nums[i] <= 10e5
     * 1 <= k <= 10e15
     */
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k && left <= right) {
                ans += right - left;
                sum -= nums[left];
                left++;
            }
        }
        ans += (long) (n - left + 1) * (n - left) / 2;
        return ans;
    }
}
