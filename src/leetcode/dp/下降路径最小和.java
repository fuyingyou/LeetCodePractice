package leetcode.dp;

public class 下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int mn = matrix[i - 1][j];
                if (j - 1 >= 0) {
                    mn = Math.min(matrix[i - 1][j - 1], mn);
                }
                if (j + 1 < n) {
                    mn = Math.min(matrix[i - 1][j + 1], mn);
                }
                matrix[i][j] += mn;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, matrix[n - 1][j]);
        }
        return ans;
    }
}
