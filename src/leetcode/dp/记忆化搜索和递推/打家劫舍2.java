package leetcode.dp.记忆化搜索和递推;

public class 打家劫舍2 {
//    public int rob(int[] nums) {
//        int n = nums.length;
//        return Math.max(dfs(nums, n - 1, 1), dfs(nums, n - 2, 0));
//    }
//
//    private int dfs(int[] nums, int i, int start) {
//        if (i < start) {
//            return 0;
//        }
//        return Math.max(dfs(nums, i - 2, start) + nums[i], dfs(nums, i - 1, start));
//    }
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(rob1(nums, 2, n - 2) + nums[0], rob1(nums, 1, n - 1));
    }

    public int rob1(int[] nums, int start, int end) {
        int f0 = 0;
        int f1 = 0;
        for (int i = start; i <= end; i++) {
            int newf = Math.max(f0 + nums[start], f1);
            f0 = f1;
            f1 = newf;
        }
        return f1;
    }

}
