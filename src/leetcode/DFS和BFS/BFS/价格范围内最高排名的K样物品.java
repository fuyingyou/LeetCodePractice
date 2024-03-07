package leetcode.DFS和BFS.BFS;

import java.util.*;

public class 价格范围内最高排名的K样物品 {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<int[]> deque = new ArrayList<>();
        deque.add(start);
        grid[start[0]][start[1]] = -1;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while (!deque.isEmpty()) {
            deque.sort((a, b) -> {
                int val1 = grid[a[0]][a[1]];
                int val2 = grid[b[0]][b[1]];
                return val1 != val2 ? val1 - val2 : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            });
            for (int[] point : deque) {
                if (grid[point[0]][point[1]] >= pricing[0] && grid[point[0]][point[1]] <= pricing[1]) {
                    ans.add(List.of(point[0], point[1]));
                    if (ans.size() == k) {
                        return ans;
                    }
                }
            }
            ArrayList<int[]> temp = new ArrayList<>();
            for (int[] point : deque) {
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && !vis[newX][newY] && grid[newX][newY] > 0) {
                        vis[newX][newY] = true;
                        temp.add(new int[]{newX, newY});
                    }
                }
            }
            deque = temp;
        }
        return ans;
    }
}
