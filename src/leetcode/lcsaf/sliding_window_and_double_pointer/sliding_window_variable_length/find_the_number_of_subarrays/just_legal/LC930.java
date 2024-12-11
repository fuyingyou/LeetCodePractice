package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_number_of_subarrays.just_legal;

public class LC930 {
    /**
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     *
     * 子数组 是数组的一段连续部分。
     * 1 <= nums.length <= 3 * 104
     * nums[i] 不是 0 就是 1
     * 0 <= goal <= nums.length
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        return get(nums, goal) - get(nums, goal + 1);
    }

    private int get(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        for (int left = 0, right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= goal && left <= right) {
                sum -= nums[left++];
            }
            ans += left;
        }
        return ans;
    }
}
