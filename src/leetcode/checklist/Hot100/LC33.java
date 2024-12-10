package leetcode.checklist.Hot100;

public class LC33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = -1, right = n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid;
            } else if (nums[mid] < nums[0]) {
                right = mid;
            }
        }
        int pre = -1, end = left + 1;
        if (target < nums[0]) {
            pre = left;
            end = n;
        }
        while (pre + 1 < end) {
            int mid =  (pre + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
