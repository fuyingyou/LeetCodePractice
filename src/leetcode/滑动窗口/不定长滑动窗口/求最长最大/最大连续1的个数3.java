package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

public class 最大连续1的个数3 {
    /**
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     */
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int left = 0;
        int cnt = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                cnt++;
                while (cnt > k) {
                    if (nums[left] == 0) {
                        cnt--;
                    }
                    left++;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
