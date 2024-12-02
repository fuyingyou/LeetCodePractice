package leetcode.lcsaf.DFS和BFS.BFS;

import java.util.Deque;
import java.util.LinkedList;

public class 地图分析 {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid.length;
        int ans = 0;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    deque.offer(new int[]{i, j});
                }
            }
        }
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!deque.isEmpty()) {
            int[] point = deque.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 0) {
                    grid[newX][newY] = grid[x][y] + 1;
                    ans = Math.max(ans, grid[newX][newY]);
                    deque.add(new int[]{newX, newY});
                }
            }
        }
        return ans - 1;
    }
}
