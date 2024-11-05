package leetcode.binary_search;

import leetcode.DFS和BFS.BFS.迷宫中离入口最近的出口;

import java.util.ArrayList;
import java.util.List;

public class 找到K个最接近的元素 {
    /**
     * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     *
     * 整数 a 比整数 b 更接近 x 需要满足：
     *
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        int left= binary_search(arr, x);
        int right = left + 1;
        while (cnt < k && left >= 0 && right < arr.length) {
            int num1 = x - arr[left];
            int num2 = arr[right] - x;
            if (num1 <= num2) {
                left--;
            } else {
                right++;
            }
            cnt++;
        }

        if (left < 0) {
            right += k - cnt;
        } else {
            left -= k - cnt;
        }

        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }

    private int binary_search(int[] arr, int target) {
        int left = -1, right = arr.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
