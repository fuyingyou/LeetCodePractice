package leetcode.lcsaf.grid_map.BFS;

import java.util.Deque;
import java.util.LinkedList;

public class 腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int res = 0;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            return res;
        }
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (true) {
            res++;
            Deque<int[]> deque2 = new LinkedList<>();
            while (!deque.isEmpty()) {
                int[] point = deque.poll();
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        cnt--;
                        if (cnt == 0) {
                            return res;
                        }
                        deque2.add(new int[]{newX, newY});
                    }
                }
            }
            deque.addAll(deque2);
            if (deque.isEmpty()) {
                break;
            }
        }
        return cnt > 0 ? -1 : res;
    }
}
