package leetcode.DFS和BFS.DFS;

public class 被围绕的区域 {
    private final static int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[][] board;
    public void solve(char[][] board) {
        this.board = board;
        int n = board.length;
        int m = board[0].length;
        if (n < 3 || m < 3) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        board[i][j] = '#';
        for (int[] arr : DIRS) {
            dfs(i + arr[0], j + arr[1]);
        }
    }

}
