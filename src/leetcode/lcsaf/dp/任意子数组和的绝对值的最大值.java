package leetcode.lcsaf.dp;

public class 任意子数组和的绝对值的最大值 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        int cur1 = 0;
        int cur2 = 0;
        for (int i = 0; i < n; i++) {
            cur1 = Math.max(cur1, 0) + nums[i];
            cur2 = Math.min(cur2, 0) + nums[i];
            mx = Math.max(cur1, mx);
            mn = Math.min(cur2, mn);
        }
        return Math.max(Math.abs(mx), Math.abs(mn));
    }
}
