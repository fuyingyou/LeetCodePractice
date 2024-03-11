package leetcode.二分算法.最小化最大值;

public class 最小化数组中的最大值 {
    public int minimizeArrayValue(int[] nums) {
        int left = 0, right = (int) (1e9 + 1);
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int mid) {
        long cnt = 0;
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] + cnt > mid) {
                cnt = nums[i] + cnt - mid;
            } else {
                cnt = 0;
            }
        }
        return cnt == 0;
    }
}
