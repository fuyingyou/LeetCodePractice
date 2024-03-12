package leetcode.二维前缀和;
public class 统计全1子矩形 {
    private int[][] sum;

    public int numSubmat(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1];    //注意范围
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
            }
        }

        for (int r1 = 0; r1 < m; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int r2 = r1 + 1; r2 < m + 1; r2++) {
                    for (int c2 = c1 + 1; c2 < n + 1; c2++) {
                        if (query(r1, c1, r2, c2) == (r2 - r1) * (c2 - c1)) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
    public int query(int r1, int c1, int r2, int c2) {
        return sum[r2][c2] - sum[r2][c1] - sum[r1][c2] + sum[r1][c1];
    }
}
