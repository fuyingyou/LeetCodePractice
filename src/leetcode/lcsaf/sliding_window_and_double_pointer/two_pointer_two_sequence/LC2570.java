package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_two_sequence;

import java.util.ArrayList;
import java.util.List;

public class LC2570 {
    /**
     * 给你两个 二维 整数数组 nums1 和 nums2.
     * nums1[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
     * nums2[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
     * 每个数组都包含 互不相同 的 id ，并按 id 以 递增 顺序排列。
     *
     * 请你将两个数组合并为一个按 id 以递增顺序排列的数组，并符合下述条件：
     *
     * 只有在两个数组中至少出现过一次的 id 才能包含在结果数组内。
     * 每个 id 在结果数组中 只能出现一次 ，并且其对应的值等于两个数组中该 id 所对应的值求和。如果某个数组中不存在该 id ，则认为其对应的值等于 0 。
     * 返回结果数组。返回的数组需要按 id 以递增顺序排列。
     * 1 <= nums1.length, nums2.length <= 200
     * nums1[i].length == nums2[j].length == 2
     * 1 <= idi, vali <= 1000
     * 数组中的 id 互不相同
     * 数据均按 id 以严格递增顺序排列
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1][0] == nums2[idx2][0]) {
                list.add(new int[]{nums1[idx1][0], nums1[idx1][1] + nums2[idx2][1]});
                idx1++;
                idx2++;
            } else if (nums1[idx1][0] < nums2[idx2][0]) {
                list.add(new int[]{nums1[idx1][0], nums1[idx1][1]});
                idx1++;
            } else {
                list.add(new int[]{nums2[idx2][0], nums2[idx2][1]});
                idx2++;
            }
        }
        while (idx1 < len1) {
            list.add(new int[]{nums1[idx1][0], nums1[idx1][1]});
            idx1++;
        }
        while (idx2 < len2) {
            list.add(new int[]{nums2[idx2][0], nums2[idx2][1]});
            idx2++;
        }
        int[][] ans = list.toArray(new int[list.size()][]);
        return ans;
    }
}
