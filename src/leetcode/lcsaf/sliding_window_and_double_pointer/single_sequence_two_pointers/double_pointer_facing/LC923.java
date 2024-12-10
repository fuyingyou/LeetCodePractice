package leetcode.lcsaf.sliding_window_and_double_pointer.single_sequence_two_pointers.double_pointer_facing;

import leetcode.checklist.Hot100.搜索二维矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class LC923 {
    /**
     * 给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
     *
     * 由于结果会非常大，请返回 109 + 7 的模。
     * 3 <= arr.length <= 3000
     * 0 <= arr[i] <= 100
     * 0 <= target <= 300
     */
    public static final int MOD = (int) (1e9 + 7);
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] > target) {
                    k--;
                } else if (arr[i] + arr[j] + arr[k] < target) {
                    j++;
                } else {
                    int cnt1 = 0;
                    int temp1 = arr[j];
                    while (j < k && arr[j] == temp1) {
                        cnt1++;
                        j++;
                    }
                    int cnt2 = 0;
                    int temp2 = arr[k];
                    // 两者不相等时，注意统计temp2的个数，所以使用等号
                    while (k >= j && arr[k] == temp2) {
                        cnt2++;
                        k--;
                    }
                    if (temp1 == temp2) {
                        ans += cnt1 * (cnt1 + 1) / 2;
                    } else {
                        ans += cnt1 * cnt2;
                    }
                    ans %= MOD;
                }
            }
        }
        return ans;
    }

}
