package leetcode.bank;

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
}
