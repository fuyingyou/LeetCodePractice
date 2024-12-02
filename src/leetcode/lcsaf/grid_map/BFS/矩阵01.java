package leetcode.lcsaf.grid_map.BFS;

import java.util.Deque;
import java.util.LinkedList;

public class 矩阵01 {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else {
                    deque.add(new int[]{i, j});
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!deque.isEmpty()) {
            int[] arr = deque.pollFirst();
            int x = arr[0];
            int y = arr[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                if (mat[newX][newY] == -1) {
                    mat[newX][newY] = mat[x][y] + 1;
                    deque.add(new int[]{newX, newY});
                }
            }
        }
        return mat;
    }
}
