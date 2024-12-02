package leetcode.lcsaf.dp;

public class 珠宝的最高价值 {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length, n = frame[0].length;
        int[][] f = new int[2][n];
        int now = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0){
                    f[now][j] = f[now][j - 1];
                } else if (j == 0) {
                    f[now][j] = f[now ^ 1][j];
                } else {
                    f[now][j] = Math.max(f[now ^ 1][j], f[now][j - 1]);
                }
                f[now][j] += frame[i][j];
            }
            now ^= 1;
        }

        return f[now ^ 1][n - 1];
    }
}
