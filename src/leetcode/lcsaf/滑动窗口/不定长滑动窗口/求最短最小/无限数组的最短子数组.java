package leetcode.lcsaf.滑动窗口.不定长滑动窗口.求最短最小;

public class 无限数组的最短子数组 {
    /**
     * 给你一个下标从 0 开始的数组 nums 和一个整数 target 。
     *
     * 下标从 0 开始的数组 infinite_nums 是通过无限地将 nums 的元素追加到自己之后生成的。
     *
     * 请你从 infinite_nums 中找出满足 元素和 等于 target 的 最短 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 -1 。
     */
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int ans = Integer.MAX_VALUE;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < n * 2; right++) {
            sum += nums[right % n];
            while (sum > target % total) {
                sum -= nums[left % n];
                left++;
            }
            if (sum == target % total) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans + (int)(target / total) * n;
    }
}
