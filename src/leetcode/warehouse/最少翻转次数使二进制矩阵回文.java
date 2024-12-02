package leetcode.warehouse;

public class 最少翻转次数使二进制矩阵回文 {
    /**
     * 给你一个 m x n 的二进制矩阵 grid 。
     *
     * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
     *
     * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
     *
     * 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
     */
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] sum = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                sum[0] += grid[i][j] == grid[i][m - 1 - j] ? 0 : 1;
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n / 2; i++) {
                sum[1] += grid[i][j] == grid[n - 1 - i][j] ? 0 : 1;
            }
        }
        return Math.min(sum[0], sum[1]);
    }

    /**
     * 给你一个 m x n 的二进制矩阵 grid 。
     * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
     * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
     * 请你返回 最少 翻转次数，使得矩阵中 所有 行和列都是 回文的 ，且矩阵中 1 的数目可以被 4 整除 。
     * @param grid
     * @return
     */
    public int minFlips2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                int b = n - i - 1;
                int r = m - j - 1;
                int cnt = 0;
                if (grid[i][j] == 1) {
                    cnt++;
                }
                if (grid[i][r] == 1) {
                    cnt++;
                }
                if (grid[b][j] == 1) {
                    cnt++;
                }
                if (grid[b][r] == 1) {
                    cnt++;
                }
                ans += cnt > 2 ? 4 - cnt : cnt;
            }
        }

        int total1 = 0;
        int sum = 0;
        if (n % 2 == 1) {
            int row = n / 2;
            for (int j = 0; j < m / 2; j++) {
                if (grid[row][j] == grid[row][m - j - 1]) {
                    if (grid[row][j] == 1) {
                        total1 += 2;
                    }
                } else {
                    sum++;
                }
            }
        }
        if (m % 2 == 1) {
            int col = m / 2;
            for (int i = 0; i < n / 2; i++) {
                if (grid[i][col] == grid[n - i - 1][col]) {
                    if (grid[i][col] == 1) {
                        total1 += 2;
                    }
                } else {
                    sum++;
                }
            }
        }

        if (total1 % 4 == 2 && sum < 1) {
            ans += 2;
        } else {
            ans += sum;
        }

        if (n % 2 == 1 && m % 2 == 1) {
            ans += grid[n / 2][m / 2];
        }
        return ans;
    }
}
