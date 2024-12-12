package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_one_sequence.two_pointer_facing;

import java.util.Arrays;

public class LC1471 {
    /**
     * 给你一个整数数组 arr 和一个整数 k 。
     * 设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
     *  |arr[i] - m| > |arr[j] - m|
     *  |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
     * 请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。
     * 中位数 是一个有序整数列表中处于中间位置的值。形式上，如果列表的长度为 n ，那么中位数就是该有序列表（下标从 0 开始）中位于 ((n - 1) / 2) 的元素。
     * 例如 arr = [6, -3, 7, 2, 11]，n = 5：数组排序后得到 arr = [-3, 2, 6, 7, 11] ，数组的中间位置为 m = ((5 - 1) / 2) = 2 ，中位数 arr[m] 的值为 6 。
     * 例如 arr = [-7, 22, 17, 3]，n = 4：数组排序后得到 arr = [-7, 3, 17, 22] ，数组的中间位置为 m = ((4 - 1) / 2) = 1 ，中位数 arr[m] 的值为 3 。
     * 1 <= arr.length <= 10^5
     * -10^5 <= arr[i] <= 10^5
     * 1 <= k <= arr.length
     */
    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int left = 0, right = n - 1;
        int[] ans = new int[k];
        int idx = 0;
        int m = arr[(n - 1) / 2];
        while (left <= right) {
            if (idx == k) {
                break;
            }
            if (Math.abs(arr[left] - m) > Math.abs(arr[right] - m)) {
                ans[idx++] = arr[left];
                left++;
            } else if (Math.abs(arr[left] - m) == Math.abs(arr[right] - m)) {
                if (arr[left] > arr[right]) {
                    ans[idx++] = arr[left];
                    left++;
                } else {
                    ans[idx++] = arr[right];
                    right--;
                }
            } else {
                ans[idx++] = arr[right];
                right--;
            }
            for (int x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,7,11,7,6,8};
        int k = 5;
        System.out.println(getStrongest(arr, k));
    }
}