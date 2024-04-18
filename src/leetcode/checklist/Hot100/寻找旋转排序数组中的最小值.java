package leetcode.checklist.Hot100;

public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n-1]) {
            return nums[0];
        }
        int left = -1, right = n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid;
            } else if (nums[mid] < nums[0]) {
                right = mid;
            }
        }
        return nums[right];
    }
}
