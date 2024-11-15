package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

public class 删掉一个元素以后全为1的最长子数组 {
    /**
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     *
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     *
     * 如果不存在这样的子数组，请返回 0 。
     */
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ans = 0;
        int cnt = 0;
        while (right < n) {
            if (nums[right] == 0) {
                cnt++;
                while (cnt > 1) {
                    if (nums[left] == 0) {
                        cnt--;
                    }
                    left++;
                }
            }
            ans = Math.max(ans, right - left);
            right++;
        }
        ans = Math.max(ans, right - left - 1);
        return ans;
    }
}
