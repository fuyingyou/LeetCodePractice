package leetcode.lcsaf.sliding_window_and_double_pointer.two_pointer_one_sequence.two_pointer_facing;

public class LC42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * n == height.length
     * 1 <= n <= 2 * 10e4
     * 0 <= height[i] <= 10e5
     */

    // 前缀后缀
    public int trap1(int[] height) {
        int n = height.length;
        int[] pre = new int[n + 1];
        int[] end = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = Math.max(pre[i], height[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            end[i] = Math.max(end[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(pre[i + 1], end[i]) - height[i];
        }
        return ans;
    }

    // 双指针做法
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int preMax = 0,endMax = 0;
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            endMax = Math.max(endMax, height[right]);
            ans += preMax < endMax ? preMax - height[left++] : endMax - height[right--];
        }
        return ans;
    }
}
