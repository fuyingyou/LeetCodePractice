package leetcode.lcsaf.binary_search;

import java.util.Arrays;

public class Test2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = binary_search(nums, lower - nums[i]);
            int right = binary_search(nums, upper - nums[i] + 1);
            if (i >= right) {
                ans += right - left;
            } else if (i > left) {
                ans += i - left;
            }
            // ans += Math.min(right - left, Math.max(i - left, 0));
        }

        return ans;
    }

    private int binary_search(int[] nums, int value) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < value) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
