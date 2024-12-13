package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_two_sequence;

public class LC1855 {
    /**
     * 给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
     * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i 。
     *
     * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
     *
     * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
     * 1 <= nums1.length <= 10e5
     * 1 <= nums2.length <= 10e5
     * 1 <= nums1[i], nums2[j] <= 10e5
     * nums1 和 nums2 都是 非递增 数组
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 1;
        while (idx1 < len1 && idx2 < len2 && idx1 <= idx2) {
            if (nums1[idx1] <= nums2[idx2]) {
                ans = Math.max(ans, idx2 - idx1);
            } else {
                idx1++;
            }
            idx2++;
        }

        return ans;
    }
}
