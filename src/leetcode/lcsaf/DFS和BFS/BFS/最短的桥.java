package leetcode.lcsaf.DFS和BFS.BFS;

import java.util.Deque;
import java.util.LinkedList;

public class 最短的桥 {


    public static int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        Deque<int[]> island = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    deque.offer(new int[]{i ,j});
                    grid[i][j] = -1;
                    int[] dx = new int[]{-1, 1, 0, 0};
                    int[] dy = new int[]{0, 0, -1, 1};
                    while (!deque.isEmpty()) {
                        int[] point = deque.poll();
                        island.add(point);
                        int x = point[0];
                        int y = point[1];
                        for (int k = 0; k < 4; k++) {
                            int newX = x + dx[k];
                            int newY = y + dy[k];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                                grid[newX][newY] = -1;
                                deque.add(new int[]{newX, newY});
                            }
                        }
                    }
                    while (!island.isEmpty()) {
                        int[] point = island.poll();
                        int x = point[0];
                        int y = point[1];
                        for (int k = 0; k < 4; k++) {
                            int newX = x + dx[k];
                            int newY = y + dy[k];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                                if (grid[newX][newY] == 0) {
                                    grid[newX][newY] = grid[x][y] - 1;
                                    island.add(new int[]{newX, newY});
                                } else if (grid[newX][newY] == 1) {
                                    return -grid[x][y] - 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,1,0}, {0,0,0}, {0,0,1}};
        System.out.println(shortestBridge(arr));
    }
}
