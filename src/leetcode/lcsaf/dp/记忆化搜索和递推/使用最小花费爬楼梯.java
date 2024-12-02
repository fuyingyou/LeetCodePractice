package leetcode.lcsaf.dp.记忆化搜索和递推;

public class 使用最小花费爬楼梯 {
//    public int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        return dfs(cost, n);
//    }
//
//    private int dfs(int[] cost, int i) {
//        if (i < 2) {
//            return 0;
//        }
//        return Math.min(dfs(cost, i - 1) + cost[i - 1], dfs(cost, i - 2) + cost[i - 2]);
//    }
//    public int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        int[] f = new int[n + 1];
//        for (int i = 0; i < n - 1; i++) {
//            f[i + 2] = Math.min(f[i] + cost[i], f[i + 1] + cost[i + 1]);
//        }
//        return f[n];
//    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int f0 = 0, f1 = 0;
        for (int i = 0; i < n - 1; i++) {
            int f2 = Math.min(f0 + cost[i], f1 + cost[i + 1]);
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }
}
