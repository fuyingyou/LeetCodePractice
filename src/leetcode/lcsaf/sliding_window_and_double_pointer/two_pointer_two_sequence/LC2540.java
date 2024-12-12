package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_two_sequence;

public class LC2540 {
    /**
     * 给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
     *
     * 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
     * 1 <= nums1.length, nums2.length <= 10e5
     * 1 <= nums1[i], nums2[j] <= 10e9
     * nums1 和 nums2 都是 非降序 的。
     */
    public int getCommon(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] == nums2[idx2]) {
                return nums1[idx1];
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return -1;
    }
}
