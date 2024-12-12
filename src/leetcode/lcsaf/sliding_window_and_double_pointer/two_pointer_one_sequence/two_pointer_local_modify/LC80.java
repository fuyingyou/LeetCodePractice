package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_one_sequence.two_pointer_local_modify;

public class LC80 {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 1 <= nums.length <= 3 * 10e4
     * -10e4 <= nums[i] <= 10e4
     * nums 已按升序排列
     */
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int x : nums) {
            if (idx < 2 || nums[idx - 2] != x) {
                nums[idx] = x;
                idx++;
            }
        }
        return idx;
    }
}
