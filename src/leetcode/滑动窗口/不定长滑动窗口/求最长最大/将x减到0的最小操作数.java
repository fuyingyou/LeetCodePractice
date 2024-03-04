package leetcode.滑动窗口.不定长滑动窗口.求最长最大;

import java.util.Arrays;

public class 将x减到0的最小操作数 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = Arrays.stream(nums).sum() - x;
        if (target < 0) {
            return -1;
        }
        int mxLen = -1;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                mxLen = Math.max(mxLen, i - left + 1);
            }
        }
        return mxLen < 0 ? -1 : n - mxLen;
    }
}
