package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_number_of_subarrays.shorter_more_legal;

public class LC713 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
     * 1 <= nums.length <= 3 * 10e4
     * 1 <= nums[i] <= 1000
     * 0 <= k <= 10e6
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int mul = 1;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            mul *= nums[right];
            while (mul >= k && left <= right) {
                ans += right - left;
                mul /= nums[left];
                left++;
            }
        }
        ans += (n - left) * (n - left + 1) / 2;
        return ans;
    }
}
