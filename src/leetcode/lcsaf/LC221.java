package leetcode.lcsaf;

public class LC221 {
    private int[][] sum;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1];    //注意范围
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j] - '0';
            }
        }

        int k = Math.min(m, n);
        int ans = 0;
        for (int d = 1; d <= k; d++) {
            for (int r1 = 0; r1 < m - d + 1; r1++) {
                for (int c1 = 0; c1 < n - d + 1; c1++) {
                    int r2 = r1 + d;
                    int c2 = c1 + d;
                    if (query(r1, c1, r2, c2) == d * d) {
                        ans = Math.max(ans, d);
                    }
                }
            }
        }
        return ans * ans;
    }
    public int query(int r1, int c1, int r2, int c2) {
        return sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
    }
}
