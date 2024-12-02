package leetcode.lcsaf.grid_map.BFS;

import java.util.Deque;
import java.util.LinkedList;

public class 矩阵中移动的最大次数 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] vis = new int[m];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            deque.add(i);
        }
        for (int j = 0; j < n - 1; j++) {
            int size = deque.size();
            while (size-- > 0) {
                int x = deque.poll();
                for (int i = Math.max(0, x - 1); i < Math.min(m, x + 2); i++) {
                    if (vis[i] != j + 1 && grid[i][j + 1] > grid[x][j]) {
                        vis[i] = j + 1;
                        deque.add(i);
                    }
                }
            }
            if (deque.size() == 0) {
                return j;
            }
        }
        return n - 1;
    }
}
