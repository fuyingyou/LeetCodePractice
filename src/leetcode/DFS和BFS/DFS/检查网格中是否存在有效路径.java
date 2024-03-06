package leetcode.DFS和BFS.DFS;

public class 检查网格中是否存在有效路径 {
    int[][] grid;
    int[][] visited;
    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int m = grid[0].length;
        visited = new int[n][m];
        if (grid[0][0] == 1) {
            return dfs(0, 0, 2);
        } else if (grid[0][0] == 2) {
            return dfs(0, 0, 1);
        } else if (grid[0][0] == 3) {
            return dfs(0, 0, 2);
        } else if (grid[0][0] == 4) {
            return dfs(0, 0, 3);
        } else if (grid[0][0] == 5) {
            return false;
        } else {
            return dfs(0, 0, 1);
        }

    }
    private boolean dfs(int i, int j, int x) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        if (visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1;
        if (i == n - 1 && j == m - 1) {
            if (x == 1 && (grid[i][j] == 2 || grid[i][j] == 5 || grid[i][j] == 6)) {
                return true;
            }
            if (x == 2 && (grid[i][j] == 1 || grid[i][j] == 3 || grid[i][j] == 5)) {
                return true;
            }
            if (x == 3 && (grid[i][j] == 1 || grid[i][j] == 4 || grid[i][j] == 6)) {
                return true;
            }
            if (x == 4 && (grid[i][j] == 2 || grid[i][j] == 3 || grid[i][j] == 4)) {
                return true;
            }
        }
        if (x == 1) {
            if (grid[i][j] == 2) {
                return dfs(i + 1, j, 1);
            } else if (grid[i][j] == 5) {
                return dfs(i, j - 1, 3);
            } else if (grid[i][j] == 6) {
                return dfs(i, j + 1, 2);
            } else {
                return false;
            }
        } else if (x == 2) {
            if (grid[i][j] == 1) {
                return dfs(i, j + 1, 2);
            } else if (grid[i][j] == 3) {
                return dfs(i + 1, j, 1);
            } else if (grid[i][j] == 5) {
                return dfs(i - 1, j, 4);
            } else {
                return false;
            }
        } else if (x == 3) {
            if (grid[i][j] == 1) {
                return dfs(i, j - 1, 3);
            } else if (grid[i][j] == 4) {
                return dfs(i + 1, j, 1);
            } else if (grid[i][j] == 6) {
                return dfs(i - 1, j, 4);
            } else {
                return false;
            }
        } else {
            if (grid[i][j] == 2) {
                return dfs(i - 1, j, 4);
            } else if (grid[i][j] == 3) {
                return dfs(i, j - 1, 3);
            } else if (grid[i][j] == 4) {
                return dfs(i, j + 1, 2);
            } else {
                return false;
            }
        }
    }
}
