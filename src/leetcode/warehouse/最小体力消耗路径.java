package leetcode.warehouse;

import leetcode.common.UnionFind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 最小体力消耗路径 {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 1 < m) {
                    edges.add(new int[]{
                            Math.abs(heights[i][j + 1] - heights[i][j]),
                            i * m + j,
                            i * m + j + 1
                    });
                }
                if (i + 1 < n) {
                    edges.add(new int[]{
                            Math.abs(heights[i + 1][j] - heights[i][j]),
                            i * m + j,
                            (i + 1) * m + j
                    });
                }
            }
        }
        edges.sort(Comparator.comparingInt(o -> o[0]));
        UnionFind unionFind = new UnionFind(n * m);
        for (int[] edge : edges) {
            unionFind.union(edge[1], edge[2]);
            if (unionFind.find(0) == unionFind.find(n * m - 1)) {
                return edge[0];
            }
        }
        return 0;
    }
}
