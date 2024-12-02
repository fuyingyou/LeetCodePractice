package leetcode.warehouse;

public class LC2401 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int x = 0;
        for (int left = 0, right = 0; right < n; right++) {
            while ((x & nums[right]) > 0) {
                x ^= nums[left++];
            }
            x |= nums[right];
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
