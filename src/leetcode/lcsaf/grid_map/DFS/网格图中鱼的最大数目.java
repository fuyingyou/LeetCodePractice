package leetcode.lcsaf.grid_map.DFS;

public class 网格图中鱼的最大数目 {
    private int[][] grid;
    private static final int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        int ans = grid[i][j];
        grid[i][j] = 0;
        for (int[] x : dir) {
            int newX = i + x[0];
            int newY = j + x[1];
            if (newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] == 0) {
                continue;
            }
            ans += dfs(newX, newY);
        }
        return ans;
    }
}
