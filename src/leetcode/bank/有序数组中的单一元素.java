package leetcode.bank;

public class 有序数组中的单一元素 {
    /**
     * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
     * 请你找出并返回只出现一次的那个数。
     * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
     */

    public int singleNonDuplicate(int[] nums) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[0];
    }

}
