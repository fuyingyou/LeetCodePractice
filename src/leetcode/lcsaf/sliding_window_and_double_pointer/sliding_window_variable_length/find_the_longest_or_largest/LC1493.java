package leetcode.lcsaf.sliding_window_and_double_pointer.sliding_window_variable_length.find_the_longest_or_largest;

public class LC1493 {
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
