package leetcode.lcsaf.grid_map.BFS;

import java.util.Deque;
import java.util.LinkedList;

public class 迷宫中离入口最近的出口 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] vis = new int[m][n];
        vis[entrance[0]][entrance[1]] = 1;
        int ans = Integer.MAX_VALUE;
        Deque<int[]> deque = new LinkedList<>();
        deque.add(entrance);

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!deque.isEmpty()) {
            int[] point = deque.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                if (maze[newX][newY] == '.' && vis[newX][newY] == 0) {
                    vis[newX][newY] = vis[x][y] + 1;
                    deque.add(new int[]{newX, newY});
                    if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) {
                        ans = Math.min(ans, vis[newX][newY]);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans - 1;
    }
}
