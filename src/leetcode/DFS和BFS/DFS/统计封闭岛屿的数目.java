package leetcode.DFS和BFS.DFS;

public class 统计封闭岛屿的数目 {
    private final static int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] grid;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && dfs(i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    private boolean dfs(int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean res = true;
        for (int[] arr : DIRS) {
            res = dfs(i + arr[0], j + arr[1]) && res;
        }
        return res;
    }
}
