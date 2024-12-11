package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_number_of_subarrays.just_legal;

public class LC1248 {
    /**
     * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     *
     * 请返回这个数组中 「优美子数组」 的数目。
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= nums.length
     */
    public int numberOfSubarrays(int[] nums, int k) {
        return get(nums, k) - get(nums, k + 1);
    }

    private int get(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        for (int left = 0, right = 0; right < n; right++) {
            sum += nums[right] % 2;
            while (sum >= k) {
                sum -= nums[left++] % 2;
            }
            ans += left;
        }

        return ans;
    }
}
