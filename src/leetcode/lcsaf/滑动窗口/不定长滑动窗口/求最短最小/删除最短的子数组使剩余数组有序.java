package leetcode.lcsaf.滑动窗口.不定长滑动窗口.求最短最小;

public class 删除最短的子数组使剩余数组有序 {
    /**
     * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
     * 一个子数组指的是原数组中连续的一个子序列。
     * 请你返回满足题目要求的最短子数组的长度。
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        if (right == 0) {
            return 0;
        }

        int ans = right;

        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; left++) {
            while (right < n && arr[right] < arr[left]) {
                right++;
            }
            ans = Math.min(ans, right - left - 1);
        }

        return ans;
    }
}
