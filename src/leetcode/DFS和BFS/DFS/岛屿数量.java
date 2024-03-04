package leetcode.DFS和BFS.DFS;

public class 岛屿数量 {

    private final static int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            dfs(i + dir[0], j + dir[1]);
        }
    }
}
