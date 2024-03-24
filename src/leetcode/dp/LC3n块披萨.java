package leetcode.dp;

import java.util.Arrays;

public class LC3n块披萨 {
//    private int[][][] memo;
//    public int maxSizeSlices(int[] slices) {
//        int n = slices.length;
//        int target = n / 3;
//        memo = new int[n][2][target + 1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(memo[i][0], -1);
//            Arrays.fill(memo[i][1], -1);
//        }
//        return Math.max(dfs(slices, n - 3, 1, target - 1) + slices[n - 1], dfs(slices, n - 2, 0, target));
//    }
//
//    private int dfs(int[] slices, int i, int left, int target) {
//        if (target == 0 || i < left) {
//            return 0;
//        }
//        if (memo[i][left][target] != -1) {
//            return memo[i][left][target];
//        }
//        memo[i][left][target] = Math.max(dfs(slices, i - 2, left, target - 1) + slices[i], dfs(slices, i - 1, left, target));
//        return memo[i][left][target];
//    }
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        System.arraycopy(slices, 0, arr1, 0, n - 1);
        System.arraycopy(slices, 1, arr2, 0, n - 1);
        return Math.max(cal(arr1), cal(arr2));
    }

    private int cal(int[] arr) {
        int n = arr.length;
        int target = (n + 1) / 3;
        int[][] f = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], -1);
        }
        f[0][0] = 0;
        f[0][1] = arr[0];
        f[1][0] = 0;
        f[1][1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            f[i][0] = 0;
            for (int j = 1; j <= target; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i - 2][j - 1] + arr[i]);
            }
        }
        return f[n - 1][target];
    }
}
