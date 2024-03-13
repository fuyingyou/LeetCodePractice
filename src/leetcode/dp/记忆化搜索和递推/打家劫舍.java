package leetcode.dp.记忆化搜索和递推;

public class 打家劫舍 {
//    public int rob(int[] nums) {
//        int n = nums.length;
//        return dfs(nums, n - 1);
//    }
//
//    private int dfs(int[] nums, int i) {
//        if (i < 0) {
//            return 0;
//        }
//        return Math.max(dfs(nums, i - 1), dfs(nums, i - 2) + nums[i]);
//    }
//    public int rob(int[] nums) {
//        int n = nums.length;
//        int[] f = new int[n + 2];
//        for (int i = 0; i < n; i++) {
//            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
//        }
//        return f[n + 1];
//    }
    public int rob(int[] nums) {
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            int f2 = Math.max(f1, f0 + x);
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }
}
