package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_two_sequence;

import java.util.Arrays;

public class LC1385 {
    /**
     * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
     *
     * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
     * 1 <= arr1.length, arr2.length <= 500
     * -10^3 <= arr1[i], arr2[j] <= 10^3
     * 0 <= d <= 100
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int len2 = arr2.length;
        int j = 0;
        int ans = 0;
        for (int x : arr1) {
            while (j < len2 && arr2[j] < x - d) {
                j++;
            }
            if (j == len2 || arr2[j] > x + d) {
                ans++;
            }
        }
        return ans;
    }
}
